import { fromJS } from 'immutable';
import containerResultsReducer from '../reducer';

describe('containerResultsReducer', () => {
  it('returns the initial state', () => {
    expect(containerResultsReducer(undefined, {})).toEqual(fromJS({}));
  });
});
