import axios from 'axios';
import { mockPolicyResponse } from '../../../../__mocks__/policyMock';

export const PRICE = {
  GET: 'PRICE_GET',
  SUCCESS: 'PRICE_SUCCESS',
  ERROR: 'PRICE_ERROR',
};
export const successPrice = price => ({
  type: PRICE.SUCCESS,
  price,
});

export const errorPrice = json => ({
  type: PRICE.ERROR,
  errData: json,
});

const priceDetailsObj = {
  calculation: '',
  exposureCharacteristics: {
    fieldGroupsByLocator: '',
    fieldValues: {
      gender: [
        'Male',
      ],
      dob: [
        '1983-03-08',
      ],
      income: [
        '100000',
      ],
      occupation: [
        '6A',
      ],
      height_ft: [
        '5',
      ],
      height_inches: [
        '7',
      ],
      weight: [
        '165',
      ],
      diabetes: [
        'No',
      ],
      hospitalized: [
        'No',
      ],
      seen_doctor: [
        'No',
      ],
      basemoben: [
        '3000',
      ],
    },
  },
  exposureName: 'insured_person',
  perilCharacteristics: {
  },
  perilName: 'fio',
  policyCharacteristics: {
    fieldGroupsByLocator: '',
    fieldValues: {
      address: [
        '33 New Montgomery',
      ],
      city: [
        'San francisco',
      ],
      state: [
        'CA',
      ],
      zipcode: [
        '94105',
      ],
      mode: [
        'Monthly',
      ],
    },
    policyEndTimestamp: '2019-04-03 12:30',
    policyStartTimestamp: '2018-04-03 12:30',
  },
  productName: 'disability-income',
};


export const getPrice = policyFields => (
  (dispatch, getState) => {
    if (!process.env.NODE_ENV || process.env.NODE_ENV === 'development') {
      return dispatch(successPolicy(mockPolicyResponse));
    }

    // const policyholderLocator = getState().policyholderState.policyholder.locator;
    // const productName = getState().configState.config[0].name;
    // const paymentScheduleName = policyFields.paymentSchedule;
    // const producerAppointmentStatus = policyFields.producerAppointmentStatus;
    // const policyObj = removeFields(policyFields);
    // const requestObj = Object.assign({}, { fieldValues: policyObj }, { policyholderLocator },
    //   { productName }, { exposures: [] }, { fieldGroups: [] }, { finalize: false },
    //   { paymentScheduleName }, { policyEndTimestamp: 0 },
    //   { policyStartTimestamp: 0 }, { producerAppointmentStatus });
    // // console.log(requestObj);

    return axios({
      url: '/mob_socotra_poc/policy/premium/',
      method: 'post',
      data: priceDetailsObj,
      headers: { 'Content-Type': 'application/json' },
      responseType: 'json',
    })
      .then((response) => {
        // console.log(response.data);
        dispatch(successPrice(response.data));
      })
      .catch((error) => {
        if (error.response) {
          // The request was made and the server responded with a status code
          // that falls out of the range of 2xx
          dispatch(errorPrice(error.response.data));
        } else if (error.request) {
          // The request was made but no response was received
          // `error.request` is an instance of XMLHttpRequest in the browser and an instance of
          // http.ClientRequest in node.js
          dispatch(errorPrice({ errorMessage: 'bad request' }));
        } else {
          // Something happened in setting up the request that triggered an Error
          dispatch(errorPrice(error));
        }
      });
  }
);
