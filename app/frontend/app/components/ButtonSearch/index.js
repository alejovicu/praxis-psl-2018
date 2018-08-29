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

  constructor() {
    super();

    this.state = {
      value: ''
    };

    this.handleClickEvent = this.handleClickEvent.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }

  handleChange(event) {
    this.setState({value: event.target.value});
  }

  handleClickEvent() {
    console.log('This is the value of the input', this.state.value);
    this.props.fetchUsers();
  }

  render() {
    return (
      <div className="contenedor-uno">
        <div className="jumbotron">
          <Img src={PslLogo} alt="react-boilerplate - Logo" />
          <div><h1 className="display-3">Praxis 2018</h1></div>
        </div>
        <div className="form-horizontal">
          <div className="form-group">
            <input type="text" className="form-control" value={this.state.value} onChange={this.handleChange} />
          </div>
          <div className="form-group">
            <button className="btn btn-dark" type="submit" onClick={this.handleClickEvent}>
              Ejecutar comando
            </button>
          </div>
        </div>
      </div>
    );
  }
}

ButtonSearch.propTypes = {};

export default ButtonSearch;
