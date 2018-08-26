/**
 *
 * ButtonSearch
 *
 */

import React from 'react';

import { FormattedMessage } from 'react-intl';
import messages from './messages';
import Img from '../Img';
import PslLogo from './psl-logo.png';

/* eslint-disable react/prefer-stateless-function */
class ButtonSearch extends React.Component {
  render() {
    return (
      <div className="contenedor-uno">
        <div class="jumbotron">
          <Img src={PslLogo} alt="react-boilerplate - Logo" />
          <div><h1 class="display-3">Praxis 2018</h1></div>
        </div>
        <div className="form-horizontal">
          <div className="form-group">
            <input type="text" name="fname" className="form-control" />
          </div>
          <div className="form-group">
            <button class="btn btn-dark" type="submit">Ejecutar comando</button>
          </div>
        </div>
      </div>
    );
  }
}

ButtonSearch.propTypes = {};

export default ButtonSearch;
