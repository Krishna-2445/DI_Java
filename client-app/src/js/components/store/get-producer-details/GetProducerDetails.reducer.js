import { PRODUCERDETAILS } from './GetProducerDetails.action';

export const initialState = {
  producerDetails: {},
};

const producerDetailsReducer = (state = initialState, action) => {
  switch (action.type) {
    case PRODUCERDETAILS.GET:
      return Object.assign({}, state, {
        isLoading: true,
        error: false,
      });
    case PRODUCERDETAILS.SUCCESS:
      return Object.assign({}, state, {
        isLoading: false,
        producerDetails: action.producerDetails,
        error: false,
      });
    case PRODUCERDETAILS.ERROR:
      return Object.assign({}, state, {
        isLoading: false,
        errorData: action.errData,
        error: true,
      });
    default:
      return state;
  }
};

export default producerDetailsReducer;
