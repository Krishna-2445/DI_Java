package com.mutualofomaha.mob.java.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mutualofomaha.mob.java.exception.SocotraServiceException;
import com.mutualofomaha.mob.java.modal.CreatePolicyRequest;
import com.mutualofomaha.mob.java.proxy.CheckExistingPerilPremiumProxy;
import com.mutualofomaha.mob.java.proxy.CreatePolicyHolderProxy;
import com.mutualofomaha.mob.java.proxy.CreatePolicyProxy;
import com.mutualofomaha.mob.java.proxy.request.*;
import com.mutualofomaha.mob.java.proxy.response.CalculationResponse;
import com.mutualofomaha.mob.java.proxy.response.CreatePolicyResponse;
import com.mutualofomaha.mob.java.proxy.response.PolicyHolderCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    PolicyHolderCreateProxyRequest holderCreateProxyRequest;

    @Autowired
    PolicyCreateProxyRequest policyCreateProxyRequest;

    @Autowired
    PolicyHolderDTO holderDTO;

    @Autowired
    CreatePolicyHolderProxy policyHolderProxy;

    @Autowired
    ExposureCreateRequest exposureCreateRequest;

    @Autowired
    PerilCreateRequest perilCreateRequest;

    @Autowired
    PolicyCreateRequest policyCreateRequest;

    @Autowired
    CreatePolicyProxy createPolicyProxy;


    @Autowired
    CreatePolicyRequest policyRequest;

    @Autowired
    CheckExistingPerilPremiumProxy premiumProxy;

    @Autowired
    CheckExistingPerilPremiumRequest premiumRequest;

    @Autowired
    private ObjectMapper objectMapper;

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";

    @Override
    public CalculationResponse checkExistingPerilPremium(CreatePolicyRequest policyRequest) throws SocotraServiceException, ParseException {
        premiumRequest.setCalculation(String.valueOf(getCalculatedResult(policyRequest)));
        premiumRequest.setPerilDisplayId(getPerilDisplayId(policyRequest));
        return premiumProxy.checkExistingPerilPremium(premiumRequest);
    }

    private double getCalculatedResult(CreatePolicyRequest policyRequest) throws ParseException {

        Map<String, List<String>> policy_v = policyRequest.getPolicy().getFieldValues();
        Map<String, List<String>> exp_v = policyRequest.getPolicy().getExposure().getFieldValues();

        String fio_rate = getFIORateMap().get(getFioKey(policyRequest, policy_v, exp_v));
        double fio_amount = getFioAmount(exp_v);
        double occ_factor = getOccFactor(exp_v);
        double rate_multiplier = getRateMultiplier(exp_v);
        double modal_factor = getModalFactor(policy_v);

        return fio_amount * 0.01 * Double.parseDouble(fio_rate) * occ_factor * modal_factor * rate_multiplier * 2;

    }


    private String getPerilDisplayId(CreatePolicyRequest policyRequest) throws SocotraServiceException {

        CreatePolicyResponse policyResponse;

        holderCreateProxyRequest.setPolicyHolder(policyRequest.getPolicy().getPolicyHolder());

        PolicyHolderCreateResponse holderCreateResponse = policyHolderProxy.createPolicyHolder(holderCreateProxyRequest);

        String locator = holderCreateResponse.getLocator();
        perilCreateRequest.setName(policyRequest.getPolicy().getPeril().getName());

        exposureCreateRequest.setExposureName(policyRequest.getPolicy().getExposure().getExposureName());
        exposureCreateRequest.setFieldValues(policyRequest.getPolicy().getExposure().getFieldValues());
        exposureCreateRequest.setPerils(Arrays.asList(perilCreateRequest));

        policyCreateRequest.setProductName(policyRequest.getPolicy().getProductName());
        policyCreateRequest.setPolicyholderLocator(locator);
        policyCreateRequest.setExposures(Arrays.asList(exposureCreateRequest));
        policyCreateRequest.setFieldValues(policyRequest.getPolicy().getFieldValues());

        policyCreateRequest.setPolicyStartTimestamp(getStartTimeStamp(policyRequest.getPolicy().getPolicyStartTimestamp()));
        policyCreateRequest.setPolicyEndTimestamp(getEndTimeStamp(policyRequest.getPolicy().getPolicyEndTimestamp()));

        policyCreateRequest.setFieldGroups(Arrays.asList());

        policyCreateRequest.setFinalize(policyRequest.getPolicy().getFinalize());

        policyCreateProxyRequest.setRequest(policyCreateRequest);

        policyResponse = createPolicyProxy.createPolicy(policyCreateProxyRequest);
        return policyResponse.getExposures().get(0).getPerils().get(0).getDisplayId();

    }


    private double getModalFactor(Map<String, List<String>> policy_v) {
        double modal_factor = 1.0;
        if (policy_v.get("mode").get(0).equals("Monthly")) {
            modal_factor = 0.0875 * 12;
        }
        return modal_factor;
    }

    private String getFioKey(CreatePolicyRequest policyRequest, Map<String, List<String>> policy_v, Map<String, List<String>> exp_v) throws ParseException {
        Long policy_start = getTimeInMills(policyRequest.getPolicy().getPolicyStartTimestamp());
        Long dob = getTimeStampInMills(exp_v.get("dob").get(0));

        Integer age = getAge(policy_start, dob);
        Integer age_band = getAgeBand(age);
        String gender = getGender(exp_v);

        String year = String.valueOf(getYearFromMills(policy_start));
        return getFioKey(policy_v, age_band, gender, year);
    }

    private Long getTimeInMills(String policyStartTimestamp) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT); // Month.Day.Year
        Date d = formatter.parse(policyStartTimestamp);
        return d.getTime();
    }

    private double getRateMultiplier(Map<String, List<String>> exp_v) {
        double bmi = getBmi(exp_v);
        double rate_up = getRateUp(bmi);
        return 1 + rate_up;
    }

    private double getFioAmount(Map<String, List<String>> exp_v) {

        double basemoben = Integer.parseInt(exp_v.get("basemoben").get(0));
        Integer max_ben_occ = 10000;

        double fio_amount1 = basemoben * 2;
        double fio_amount2 = max_ben_occ - basemoben;

        double fio_amount;
        if (fio_amount2 > fio_amount1) {
            fio_amount = fio_amount1;
        } else {
            fio_amount = fio_amount2;
        }
        return fio_amount;
    }

    private Integer getAge(Long policy_start, Long dob) {
        Long policy_start_and_dob_diff = policy_start - dob;
        Integer policy_start_and_dob_diff_y = getYearFromMills(policy_start_and_dob_diff);
        return policy_start_and_dob_diff_y - 1970;
    }

    private double getBmi(Map<String, List<String>> exp_v) {
        BigInteger height_in_inches = BigInteger.valueOf(Integer.parseInt(exp_v.get("height_ft").get(0)) * 12 + Integer.parseInt(exp_v.get("height_inches").get(0)));
        BigInteger bmi_denominator = height_in_inches.pow(2);
        BigInteger weight = new BigInteger(exp_v.get("weight").get(0));
        return weight.divide(bmi_denominator.multiply(BigInteger.valueOf(703))).doubleValue();
    }

    private String getFioKey(Map<String, List<String>> policy_v, Integer age_band, String gender, String year) {
        String fioKey;
        StringJoiner fio_key = new StringJoiner("/");
        fioKey = fio_key.add(policy_v.get("state").get(0)).add(year).add(String.valueOf(age_band)).add(gender).toString();
        return fioKey;
    }


    private Integer getAgeBand(Integer age) {
        Integer age_band = 18;
        Integer[] age_bands = getAgeBands("18:41:52");

        for (Integer band : age_bands) {
            Integer current_band = band + 0;
            if (age >= current_band) {
                age_band = current_band;
            }
        }
        return age_band;
    }

    private String getGender(Map<String, List<String>> exp_v) {
        String gender;
        if ("Male".equals(exp_v.get("gender"))) {
            gender = "M";
        } else {
            gender = "F";
        }
        return gender;
    }

    private double getOccFactor(Map<String, List<String>> exp_v) {
        double occ_factor;
        switch (exp_v.get("occupation").get(0)) {
            case "1A":
                occ_factor = 2.50;
                break;
            case "2A":
                occ_factor = 1.90;
                break;
            case "3A":
                occ_factor = 1.50;
                break;
            case "4A":
                occ_factor = 1.15;
                break;
            case "5A":
                occ_factor = 1.00;
                break;
            case "6A":
                occ_factor = 0.90;
                break;
            default:
                occ_factor = 0.0;
                break;
        }
        return occ_factor;
    }

    private double getRateUp(double bmi) {
        double rate_up = 0;

        if (bmi >= 37.5) {
            rate_up = 0.75;
        } else if (bmi >= 35) {
            rate_up = 0.50;
        } else if (bmi >= 32.4) {
            rate_up = 0.25;
        }
        return rate_up;
    }

    private Map<String, String> getFIORateMap() {
        Map<String, String> fioRateMap = new HashMap<>();
        fioRateMap.put("NE/2018/18/M", "2.52");
        fioRateMap.put("NE/2018/41/M", "5.18");
        fioRateMap.put("NE/2018/52/M", "0");
        fioRateMap.put("NE/2018/18/F", "3.78");
        fioRateMap.put("NE/2018/41/F", "6.74");
        fioRateMap.put("NE/2018/52/F", "0");
        fioRateMap.put("CA/2018/18/M", "2.52");
        fioRateMap.put("CA/2018/41/M", "5.18");
        fioRateMap.put("CA/2018/52/M", "0");
        fioRateMap.put("CA/2018/18/F", "3.78");
        fioRateMap.put("CA/2018/41/F", "6.74");
        fioRateMap.put("CA/2018/52/F", "0");
        return fioRateMap;
    }


    private Long getTimeStampInMills(String dob) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Month.Day.Year
        Date d = formatter.parse(dob);
        return d.getTime();
    }

    private Integer getYearFromMills(Long policyStartAndDobDiff) {

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(policyStartAndDobDiff);
        return c.get(Calendar.YEAR);

    }

    private Integer[] getAgeBands(String ageBands) {

        String[] ageBandsArray = ageBands.split(":");
        Integer[] ageBandsIntArray = new Integer[ageBandsArray.length];
        for (int i = 0; i < ageBandsArray.length; i++) {
            String numberAsString = ageBandsArray[i];
            ageBandsIntArray[i] = Integer.parseInt(numberAsString);
        }
        return ageBandsIntArray;
    }

    private long getStartTimeStamp(String dateTime) {
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }

    private long getEndTimeStamp(String dateTime) {
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }
}
