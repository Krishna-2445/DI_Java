import { combineReducers } from 'redux';
import { routerReducer } from 'react-router-redux';
import { reducer as formReducer } from 'redux-form';
import configReducer from '../components/store/get-config/GetConfig.reducer';
import savePolicyHolderReducer from '../components/store/create-policy-holder/SavePolicyHolder.reducer';
import createPolicyReducer from '../components/store/create-policy/CreatePolicy.reducer';
import priceReducer from '../components/store/get-price/GetPrice.reducer';
import producerDetailsReducer from '../components/store/get-producer-details/GetProducerDetails.reducer';


const reducers = combineReducers({
  routing: routerReducer,
  form: formReducer,
  configState: configReducer,
  policyHolderState: savePolicyHolderReducer,
  policyResponseState: createPolicyReducer,
  producerDetailsState: producerDetailsReducer,
  priceState: priceReducer,
});

export default reducers;
