import React, { PropTypes } from 'react';
import { Button, Grid, Input, Label, Segment } from 'semantic-ui-react';


class CreatePolicyHolder extends React.Component {
  constructor(props, context) {
    super(props, context);
    this.state = {
      firstName: '',
      lastName: '',
    };
    this.savePolicyHolder = this.savePolicyHolder.bind(this);
    this.firstNameChange = this.firstNameChange.bind(this);
    this.lastNameChange = this.lastNameChange.bind(this);
  }

  firstNameChange(e) {
    this.setState({ firstName: e.target.value });
  }

  lastNameChange(e) {
    this.setState({ lastName: e.target.value });
  }

  savePolicyHolder() {
    const policyHolderObj = {
      first_name: [this.state.firstName],
      last_name: [this.state.lastName],
    };
    this.props.savePolicyHolder(policyHolderObj, this.context);
  }

  render() {
    return (
      <div>
        <Segment>
          <Label attached="top">Policy Holder</Label>
          <Grid columns={2}>
            <Grid.Column>
              <div>
                <Input fluid label="First Name" onChange={this.firstNameChange} value={this.state.firstName} />
              </div>
            </Grid.Column>
            <Grid.Column>
              <div>
                <Input fluid label="Last Name" onChange={this.lastNameChange} value={this.state.lastName} />
              </div>
              <div>
                <Button onClick={this.savePolicyHolder}>Create PolicyHolder</Button>
              </div>
            </Grid.Column>
          </Grid>
        </Segment>
      </div>
    );
  }
}

CreatePolicyHolder.propTypes = {
  savePolicyHolder: PropTypes.func.isRequired,
};

export default CreatePolicyHolder;

