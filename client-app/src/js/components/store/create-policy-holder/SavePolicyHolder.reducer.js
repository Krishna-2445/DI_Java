import toastr from 'toastr';
import { POLICYHOLDER } from './SavePolicyHolder.action';


export const initialState = {
  policyHolder: {},
};

const savePolicyHolderReducer = (state = initialState, action) => {
  switch (action.type) {
    case POLICYHOLDER.SUCCESS:
      toastr.success('Policy Holder Saved Succesfully');
      return Object.assign({}, state, {
        policyHolder: action.policyHolder,
      });
    default:
      return state;
  }
};

export default savePolicyHolderReducer;
