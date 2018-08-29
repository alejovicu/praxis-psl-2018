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
    const { users } = this.props;
    const userList = users.map((user, i) => {
      return (<li key={'user' + user.name + i}>{user.name}</li>)
    });

    return (
      <div className="contenedor-resultados">
        <div className="form-group">
          <div className="table-responsive">
            <div><b>Resultados</b></div>
            <ul>
              {userList}
            </ul>
          </div>
        </div>
      </div>
    );
  }
}

ContainerResults.propTypes = {
  dispatch: PropTypes.func.isRequired,
  users: PropTypes.array.isRequired
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
