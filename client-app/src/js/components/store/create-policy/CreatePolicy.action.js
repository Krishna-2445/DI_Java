import axios from 'axios';

export const CREATEPOLICY = {
  POST: 'CREATEPOLICY_POST',
  SUCCESS: 'CREATEPOLICY_SUCCESS',
  ERROR: 'CREATEPOLICY_ERROR',
};

export const successPolicy = policyResponse => ({
  type: CREATEPOLICY.SUCCESS,
  policyResponse,
});

// const policyReqObj = {
//   exposures: [{
//     perils: [{
//       name: 'fio',
//     }],
//     exposureName: 'insured_person',
//     fieldValues: {
//       income: ['10000'],
//       hospitalized: ['No'],
//       height_ft: ['5'],
//       occupation: ['4A'],
//       gender: ['Female'],
//       seen_doctor: ['No'],
//       dob: ['1983-03-08'],
//       basemoben: ['1000'],
//       height_inches: ['5'],
//       weight: ['100'],
//       diabetes: ['No'],
//     },
//   }],
//   fieldGroups: [],
//   policyStartTimestamp: 1522738800000,
//   policyholderLocator: '6d64387d-c4fa-4b84-9f79-1f3e6d6bfe21',
//   finalize: false,
//   policyEndTimestamp: 1554274800000,
//   fieldValues: {
//     zipcode: ['94105'],
//     mode: ['Annual'],
//     address: ['street'],
//     state: ['CA'],
//   },
//   productName: 'disability-income',
// };

const policyResponseObj =
  {
    locator: '046b7e9b-a602-43bf-b0d4-e7a733053808',
    displayId: '100001138',
    originalContractStartTimestamp: '1522738800000',
    originalContractEndTimestamp: '1554274800000',
    effectiveContractEndTimestamp: '1554274800000',
    characteristics: [{
      locator: '6227cc5d-ef6c-4571-b080-ef9df0591bc0',
      policyLocator: '046b7e9b-a602-43bf-b0d4-e7a733053808',
      startTimestamp: '1522738800000',
      endTimestamp: '1554274800000',
      policyStartTimestamp: '1522738800000',
      policyEndTimestamp: '1554274800000',
      grossPremiumCurrency: 'USD',
      taxGroups: [],
      grossTaxesCurrency: 'USD',
      fieldValues: { mode: ['Annual'], zipcode: ['94105'], address: ['street'], state: ['CA'] },
      fieldGroupsByLocator: {},
      mediaByLocator: {},
      policyholderLocator: '6d64387d-c4fa-4b84-9f79-1f3e6d6bfe21',
      productLocator: '1fcb891a-4cb4-4f8f-a6a1-acf97e6c87a0',
      createdTimestamp: '1524432767592',
      updatedTimestamp: '1524432767592',
    }],
    exposures: [{
      locator: '2f107297-79db-46c2-937d-b8f7300ac58d',
      name: 'insured_person',
      displayId: '100001140',
      characteristics: [{
        locator: 'd42deeb4-a8c0-4c94-858b-72b2b64d03ef',
        exposureLocator: '2f107297-79db-46c2-937d-b8f7300ac58d',
        startTimestamp: '1522738800000',
        endTimestamp: '1554274800000',
        fieldValues: {
          income: ['10000'],
          height_ft: ['5'],
          occupation: ['4A'],
          hospitalized: ['No'],
          seen_doctor: ['No'],
          gender: ['Female'],
          height_inches: ['5'],
          weight: ['100'],
          dob: ['1983-03-08'],
          basemoben: ['1000'],
          diabetes: ['No'],
        },
        fieldGroupsByLocator: {},
        mediaByLocator: {},
        policyholderLocator: '6d64387d-c4fa-4b84-9f79-1f3e6d6bfe21',
        productLocator: '1fcb891a-4cb4-4f8f-a6a1-acf97e6c87a0',
        policyLocator: '046b7e9b-a602-43bf-b0d4-e7a733053808',
        createdTimestamp: '1524432767592',
        updatedTimestamp: '1524432767592',
      }],
      perils: [{
        locator: 'ca126f5b-0651-4d22-8413-d70b61598064',
        displayId: '100001141',
        name: 'fio',
        exposureLocator: '2f107297-79db-46c2-937d-b8f7300ac58d',
        renewalGroup: 'ca126f5b-0651-4d22-8413-d70b61598064',
        characteristics: [{
          locator: '7a350e04-941b-4676-91f0-544c46738e69',
          perilLocator: 'ca126f5b-0651-4d22-8413-d70b61598064',
          exposureCharacteristicsLocator: 'd42deeb4-a8c0-4c94-858b-72b2b64d03ef',
          policyCharacteristicsLocator: '6227cc5d-ef6c-4571-b080-ef9df0591bc0',
          indemnityPerItemCurrency: 'USD',
          indemnityPerEventCurrency: 'USD',
          indemnityInAggregateCurrency: 'USD',
          lumpSumPaymentCurrency: 'USD',
          deductibleCurrency: 'USD',
          premiumCurrency: 'USD',
          coverageStartTimestamp: '1522738800000',
          coverageEndTimestamp: '1554274800000',
          fieldValues: {},
          fieldGroupsByLocator: {},
          mediaByLocator: {},
          policyModificationLocator: '0d1e28b2-a9fc-48cd-a968-4dd4b8a2cb7c',
          policyholderLocator: '6d64387d-c4fa-4b84-9f79-1f3e6d6bfe21',
          productLocator: '1fcb891a-4cb4-4f8f-a6a1-acf97e6c87a0',
          policyLocator: '046b7e9b-a602-43bf-b0d4-e7a733053808',
          createdTimestamp: '1524432767592',
          updatedTimestamp: '1524432767592',
        }],
        policyholderLocator: '6d64387d-c4fa-4b84-9f79-1f3e6d6bfe21',
        productLocator: '1fcb891a-4cb4-4f8f-a6a1-acf97e6c87a0',
        policyLocator: '046b7e9b-a602-43bf-b0d4-e7a733053808',
        createdTimestamp: '1524432767592',
        updatedTimestamp: '1524432767592',
      }],
      policyholderLocator: '6d64387d-c4fa-4b84-9f79-1f3e6d6bfe21',
      productLocator: '1fcb891a-4cb4-4f8f-a6a1-acf97e6c87a0',
      policyLocator: '046b7e9b-a602-43bf-b0d4-e7a733053808',
      createdTimestamp: '1524432767592',
      updatedTimestamp: '1524432767592',
    }],
    modifications: [{
      locator: '0d1e28b2-a9fc-48cd-a968-4dd4b8a2cb7c',
      name: 'modification.policy.create',
      displayId: '100001139',
      number: '0',
      effectiveTimestamp: '1522738800000',
      fieldValues: {},
      fieldGroupsByLocator: {},
      mediaByLocator: {},
      newPolicyCharacteristicsLocator: '6227cc5d-ef6c-4571-b080-ef9df0591bc0',
      newPolicyCharacteristicsLocators: ['6227cc5d-ef6c-4571-b080-ef9df0591bc0'],
      premiumChangeCurrency: 'USD',
      exposureModifications: [{
        locator: '2d9b0dda-8c5f-4123-a752-e8e62b0c5f9d',
        policyModificationLocator: '0d1e28b2-a9fc-48cd-a968-4dd4b8a2cb7c',
        exposureLocator: '2f107297-79db-46c2-937d-b8f7300ac58d',
        newExposureCharacteristicsLocator: 'd42deeb4-a8c0-4c94-858b-72b2b64d03ef',
        perilModifications: [{
          locator: 'abd328ff-4649-441d-b421-b1624b144a52',
          perilLocator: 'ca126f5b-0651-4d22-8413-d70b61598064',
          exposureModificationLocator: '2d9b0dda-8c5f-4123-a752-e8e62b0c5f9d',
          newPerilCharacteristicsLocator: '7a350e04-941b-4676-91f0-544c46738e69',
          premiumChangeCurrency: 'USD',
          policyholderLocator: '6d64387d-c4fa-4b84-9f79-1f3e6d6bfe21',
          productLocator: '1fcb891a-4cb4-4f8f-a6a1-acf97e6c87a0',
          policyLocator: '046b7e9b-a602-43bf-b0d4-e7a733053808',
        }],
        policyholderLocator: '6d64387d-c4fa-4b84-9f79-1f3e6d6bfe21',
        productLocator: '1fcb891a-4cb4-4f8f-a6a1-acf97e6c87a0',
        policyLocator: '046b7e9b-a602-43bf-b0d4-e7a733053808',
      }],
      policyholderLocator: '6d64387d-c4fa-4b84-9f79-1f3e6d6bfe21',
      productLocator: '1fcb891a-4cb4-4f8f-a6a1-acf97e6c87a0',
      policyLocator: '046b7e9b-a602-43bf-b0d4-e7a733053808',
      createdTimestamp: '1524432767592',
      updatedTimestamp: '1524432767592',
    }],
    fees: [],
    grossFees: '0.00',
    grossFeesCurrency: 'USD',
    documents: [],
    invoices: [],
    paymentScheduleName: 'upfront',
    policyholderLocator: '6d64387d-c4fa-4b84-9f79-1f3e6d6bfe21',
    productLocator: '1fcb891a-4cb4-4f8f-a6a1-acf97e6c87a0',
    productName: 'disability-income',
    createdTimestamp: '1524432767592',
    updatedTimestamp: '1524432767592',
  };

export const errorPolicy = json => ({
  type: CREATEPOLICY.ERROR,
  errData: json,
});

export const createPolicy = jsonObj => (
  (dispatch) => {
    console.log(jsonObj);
    if (!process.env.NODE_ENV || process.env.NODE_ENV === 'development') {
      // const policyHolderObj = [];
      // console.log('using mock config');
      // mockPolicyHolderJson.forEach((el) => {
      //   if (el.name !== 'global') {
      //     policyHolderObj.push(el);
      //   }
      // });
      return dispatch(successPolicy(policyResponseObj));
    }

    return axios.post('http://localhost:8079/mob_socotra_poc/policy/', jsonObj).done((response) => {
      dispatch(successPolicy(response));
    }).catch((error) => {
      dispatch(errorPolicy(error));
    });
  }
);

