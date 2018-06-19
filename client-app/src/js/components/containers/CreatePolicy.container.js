import { connect } from 'react-redux';
import CreatePolicy from '../pages/create-policy/CreatePolicy';
import { createPolicy } from '../store/create-policy/CreatePolicy.action';
import { getProducerDetails } from '../store/get-producer-details/GetProducerDetails.action';
import { getPrice } from '../store/get-price/GetPrice.action';

export function mapStateToProps(state) {
  return {
    configState: state.configState,
    policyResponseState: state.policyResponseState,
    producerDetailsState: state.producerDetailsState,
    priceState: state.priceState,
  };
}

export default connect(mapStateToProps,
  { createPolicy, getProducerDetails, getPrice })(CreatePolicy);
