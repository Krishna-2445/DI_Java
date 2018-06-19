import axios from 'axios';
// import mockPolicyHolderJson from '../../../../__mocks__/policyHolderMock';

export const POLICYHOLDER = {
  POST: 'POLICYHOLDER_POST',
  SUCCESS: 'POLICYHOLDER_SUCCESS',
  ERROR: 'POLICYHOLDER_ERROR',
};

const policyHolderObj =
  {
    locator: '3b7b8fed-6661-4833-9335-b9fc11f2b6cf',
    version: '1',
    createdTimestamp: '1524451478034',
    updatedTimestamp: '1524451478176',
    policyAccounts: [],
    policyLocators: [],
    payments: [],
    entity: {
      locator: '3b7b8fed-6661-4833-9335-b9fc11f2b6cf',
      revision: '11e8-46a0-43d22f80-986f-0242ac110002',
      accountLocator: '7f5e2de2-6e80-49ac-8742-c1464c93d209',
      createdTimestamp: '1524451478034',
      updatedTimestamp: '1524451478034',
      values: { first_name: ['firstName'], last_name: ['lastName'] },
      completed: true,
      flags: ['flag.entity.workflow.complete'],
    },
  };


export const successPolicyHolder = policyHolder => ({
  type: POLICYHOLDER.SUCCESS,
  policyHolder,
});

export const errorPolicyHolder = json => ({
  type: POLICYHOLDER.ERROR,
  errData: json,
});

export const savePolicyHolder = (jsonObj, context) => (
    (dispatch) => {
      if (!process.env.NODE_ENV || process.env.NODE_ENV === 'development') {
        // const policyHolderObj = [];
        // console.log('using mock config');
        // mockPolicyHolderJson.forEach((el) => {
        //   if (el.name !== 'global') {
        //     policyHolderObj.push(el);
        //   }
        // });
        return dispatch(successPolicyHolder(policyHolderObj)).then();
      }

      return axios.post('http://localhost:8079/mob_socotra_poc/policyholder/create/', jsonObj).done((response) => {
        context.router.push('/createPolicy');
        dispatch(successPolicyHolder(response));
      }).catch((error) => {
        dispatch(errorPolicyHolder(error));
      });
    }
  )
;

