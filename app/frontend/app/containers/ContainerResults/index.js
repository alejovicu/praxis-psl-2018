/**
 *
 * ContainerResults
 *
 */

import React from 'react';
import PropTypes from 'prop-types'
import { connect } from 'react-redux';


import { createStructuredSelector } from 'reselect';
import { compose } from 'redux';

import injectSaga from 'utils/injectSaga';
import injectReducer from 'utils/injectReducer';
import makeSelectContainerResults from './selectors';
import reducer from './reducer';
import saga from './saga';


/* eslint-disable react/prefer-stateless-function */
export class ContainerResults extends React.Component {
  render() {
    return (
      <div className="contenedor-resultados">
        <div className="form-group">
          <div className="table-responsive">
            <table>
              <thead>
                <th>Resultados</th>
              </thead>
              <tbody>
                <tr><td>Alejandro</td></tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    );
  }
}

ContainerResults.propTypes = {
  dispatch: PropTypes.func.isRequired,
};

const mapStateToProps = createStructuredSelector({
  containerresults: makeSelectContainerResults(),
});

function mapDispatchToProps(dispatch) {
  return {
    dispatch,
  };
}

const withConnect = connect(
  mapStateToProps,
  mapDispatchToProps,
);

const withReducer = injectReducer({ key: 'containerResults', reducer });
const withSaga = injectSaga({ key: 'containerResults', saga });

export default compose(
  withReducer,
  withSaga,
  withConnect,
)(ContainerResults);
