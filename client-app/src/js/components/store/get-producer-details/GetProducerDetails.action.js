import axios from 'axios';

export const PRODUCERDETAILS = {
  GET: 'PRODUCERDETAILS_GET',
  SUCCESS: 'PRODUCERDETAILS_SUCCESS',
  ERROR: 'PRODUCERDETAILS_ERROR',
};
export const successProducerDetails = producerDetails => ({
  type: PRODUCERDETAILS.SUCCESS,
  producerDetails,
});

const producerDetailsObj = {
  appointmentStatus: '0',
  licenseTypeCode: 'A',
  licenseNumber: '7999930',
  licenseEffectiveDate: '2004-03-31',
  licenseState: 'NE',
  state: 'NE',
  company: 'Mutual',
  amlCertificationUpToDate: true,
  annualTrainingUpToDate: false,
};

export const errorProducerDetails = json => ({
  type: PRODUCERDETAILS.ERROR,
  errData: json,
});

export const getProducerDetails = producerNumber => (
  (dispatch) => {
    if (!process.env.NODE_ENV || process.env.NODE_ENV === 'development') {
      // const policyHolderObj = [];
      // console.log('using mock config');
      // mockPolicyHolderJson.forEach((el) => {
      //   if (el.name !== 'global') {
      //     policyHolderObj.push(el);
      //   }
      // });
      return dispatch(successProducerDetails(producerDetailsObj));
    }

    return axios.get(`http://localhost:8079/mob_socotra_poc/producer/${producerNumber}`).done((response) => {
      dispatch(successProducerDetails(response));
    }).catch((error) => {
      dispatch(errorProducerDetails(error));
    });
  }
);

