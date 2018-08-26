import { createSelector } from 'reselect';
import { initialState } from './reducer';

/**
 * Direct selector to the containerResults state domain
 */

const selectContainerResultsDomain = state =>
  state.get('containerResults', initialState);

/**
 * Other specific selectors
 */

/**
 * Default selector used by ContainerResults
 */

const makeSelectContainerResults = () =>
  createSelector(selectContainerResultsDomain, substate => substate.toJS());

export default makeSelectContainerResults;
export { selectContainerResultsDomain };
