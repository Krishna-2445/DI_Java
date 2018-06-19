import toastr from 'toastr';
import { CREATEPOLICY } from './CreatePolicy.action';

export const initialState = {
  policyResponse: {},
};

const createPolicyReducer = (state = initialState, action) => {
  switch (action.type) {
    case CREATEPOLICY.SUCCESS:
      toastr.success('Policy Created Succesfully');
      return Object.assign({}, state, {
        policyResponse: action.policyResponse,
      });
    default:
      return state;
  }
};

export default createPolicyReducer;
