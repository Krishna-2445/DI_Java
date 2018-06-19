import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { Button, Dropdown, Grid, Input, Label, Segment } from 'semantic-ui-react';
import DatePicker from 'react-datepicker';
import moment from 'moment';

import 'react-datepicker/dist/react-datepicker.css';

class CreatePolicy extends Component {
  constructor(props) {
    super(props);
    this.state = {
      policy: {
        locator: '',
        fields: {},
        exposures: {
          fields: {},
        },
        perils: {},
        policyStartDate: moment(),
        policyEndDate: moment().year(moment().year() + 1),
        paymentSchedule: {},
      },
      configDetails: {},
      configFields: [],
      producerDetails: {},
      paymentSchedules: [],
    };

    this.updateConfigFields(props.configState);
    this.updateProducerDetails(props.producerDetailsState);
    this.updatePaymentSchedules(props.configState);

    this.handleStartDateChange = this.handleStartDateChange.bind(this);
    this.handleEndDateChange = this.handleEndDateChange.bind(this);
    this.renderField = this.renderField.bind(this);
    this.renderFields = this.renderFields.bind(this);
    this.handlePolicyFieldsChange = this.handlePolicyFieldsChange.bind(this);
    this.updateProducerNumberDetails = this.updateProducerNumberDetails.bind(this);
    this.handlePolicyFieldsSelChange = this.handlePolicyFieldsSelChange.bind(this);
    this.handlePaymentScheduleChange = this.handlePaymentScheduleChange.bind(this);
    this.createPolicy = this.createPolicy.bind(this);
    this.getPrice = this.getPrice.bind(this);
  }

  componentWillReceiveProps(nextProps) {
    console.log('updated');
    console.log(nextProps);
    this.updateConfigFields(nextProps.configState);
    this.updatePaymentSchedules(nextProps.configState);
    this.updateProducerDetails(nextProps.producerDetailsState);
  }

  getPrice() {
    this.props.getPrice();
  }

  updateConfigDetails = (configState) => {
    if (configState.configDetails) {
      this.setState({
        configDetails: configState.configDetails,
      });
    }
  };


  updatePaymentSchedules = (configState) => {
    if (configState.config.length !== 0) {
      const tempArr = configState.config.map(config =>
        config.policyConfiguration.paymentSchedules)[0];
      const options = [];
      tempArr.forEach((obj) => {
        const newOpt = {};
        newOpt.key = obj.name;
        newOpt.text = obj.displayName;
        newOpt.value = obj.name;
        options.push(newOpt);
      });

      this.setState(() => ({
        paymentSchedules: options,
      }));
    }
  };

  handleStartDateChange = (date) => {
    const policy = this.state.policy;
    policy.policyStartDate = date;
    this.setState({ policy });
  };

  handleEndDateChange = (date) => {
    const policy = this.state.policy;
    policy.policyEndDate = date;
    this.setState({ policy });
  };

  handlePolicyFieldsChange = (e) => {
    const policy = this.state.policy;
    policy.fields[e.target.name] = e.target.value;
    this.setState({ policy });
  };

  handlePolicyFieldsSelChange = (e, name) => {
    const policy = this.state.policy;
    policy.fields[name] = e.target.innerText;
    this.setState({ policy });
  };

  handlePaymentScheduleChange = (e) => {
    const policy = this.state.policy;
    policy.paymentSchedule = e.target.innerText;
    this.setState({ policy });
  };

  createPolicy() {
    const policyObj = this.state.policy;
    this.props.createPolicy(policyObj);
  }

  updateConfigFields = (configState) => {
    if (configState.config.length !== 0) {
      this.setState(() => ({
        configFields: configState.config.map(config =>
          config.policyConfiguration.fields),
      }));
    }
  };

  updateProducerDetails = (producerDetailsState) => {
    const policy = this.state.policy;
    const producerDetails = producerDetailsState.producerDetails !== {}
    ? producerDetailsState.producerDetails : {};
    Object.keys(producerDetails).forEach((key) => {
      policy.fields[key] = producerDetails[key];
    });
    if (producerDetailsState.producerDetails) {
      this.setState({
        producerDetails: producerDetailsState.producerDetails,
      });
    }
  };

  updateProducerNumberDetails = (e) => {
    if (e.target.name === 'producerNumber') {
      const producerNumber = e.target.value;
      this.props.getProducerDetails(producerNumber);
    }
  };

  renderField = (field) => {
    switch (field.type) {
      case 'string':
        return (
          <div>
            <Input
              fluid label={field.title}
              name={field.name}
              onChange={this.handlePolicyFieldsChange}
              onBlur={this.updateProducerNumberDetails}
              value={this.state.producerDetails !== {} ? this.state.producerDetails[field.name] : ''}
            />
          </div>
        );
      case 'select': {
        const fieldOpts = field.values.map(value =>
          Object.assign({ key: value }, { value }, { text: value }),
        );
        return (
          <div>
            <Dropdown
              placeholder={field.title}
              options={fieldOpts}
              name={field.name}
              onChange={e => this.handlePolicyFieldsSelChange(e, field.name)} fluid selection
            />
          </div>
        );
      }
      default:
        return (
          <div />
        );
    }
  };

  renderFields = () => {
    if (this.state.configFields && this.state.configFields.length !== 0) {
      return this.state.configFields[0].map(field => (
        <Grid.Column>
          {this.renderField(field)}
        </Grid.Column>
        ),
      );
    }

    return (
      <Grid.Column>
        <p>Loading...</p>
      </Grid.Column>
    );
  };

  render() {
    return (
      <div>
        <Segment>
          <Label attached="top">Policy</Label>
          <Grid columns={3}>
            <Grid.Column />
            <Grid.Column />
            <Grid.Column>
              <Segment padded>
                <Label attached="top">Estimated Premium</Label>
                <Input>$0.00</Input>
              </Segment>
            </Grid.Column>
          </Grid>
          <Grid columns={3}>
            <Grid.Column>
              <Segment padded>
                <Label attached="top">Start Date</Label>
                <DatePicker
                  selected={this.state.policy.policyStartDate}
                  onChange={this.handleStartDateChange}
                />
              </Segment>
            </Grid.Column>
            <Grid.Column>
              <Segment padded>
                <Label attached="top">Start Date</Label>
                <DatePicker
                  selected={this.state.policy.policyEndDate}
                  onChange={this.handleEndDateChange}
                />
              </Segment>
            </Grid.Column>
            <Grid.Column>
              <Segment padded>
                <Label attached="top">Payment Schedule</Label>
                <Dropdown
                  placeholder="Payment Schedule"
                  options={this.state.paymentSchedules}
                  onChange={this.handlePaymentScheduleChange}
                  fluid selection
                />
              </Segment>
            </Grid.Column>
          </Grid>
          <Grid columns={2}>
            {this.renderFields()}
          </Grid>
        </Segment>
        <Segment>
          <Label attached="top">Exposure</Label>
          <Grid columns={2} />
        </Segment>
        <Segment>
          <Label attached="top">Perils</Label>
          <Grid columns={2} />
        </Segment>
        <Button onClick={this.getPrice}>Get Quote</Button>
        <Button onClick={this.createPolicy}>Create Policy</Button>
      </div>
    );
  }
}

CreatePolicy.defaultProps = {
  configState: {},
  producerDetailsState: {},
};
CreatePolicy.propTypes = {
  configState: PropTypes.object,
  producerDetailsState: PropTypes.object,
  createPolicy: PropTypes.func.isRequired,
  getProducerDetails: PropTypes.func.isRequired,
  getPrice: PropTypes.func.isRequired,
};

export default CreatePolicy;

