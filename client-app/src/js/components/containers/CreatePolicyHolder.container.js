import { connect } from 'react-redux';
import CreatePolicyHolder from '../pages/create-policy-holder/CreatePolicyHolder';
import { savePolicyHolder } from '../store/create-policy-holder/SavePolicyHolder.action';


export function mapStateToProps(state) {
  return {
    policyHolderState: state.policyHolderState,
  };
}

export default connect(mapStateToProps, { savePolicyHolder })(CreatePolicyHolder);
