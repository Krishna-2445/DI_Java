import React from 'react';
import { Redirect, Route, Switch } from 'react-router-dom';
import { Container } from 'semantic-ui-react';
import CreatePolicyContainer from '../components/containers/CreatePolicy.container';
import MooHeaderContainer from '../components/theme/moo-header.container';
import CreatePolicyHolderContainer from '../components/containers/CreatePolicyHolder.container';

const RootRoutes = () => (
  <div>
    <Route path="/" component={MooHeaderContainer} />
    <Container>
      <Switch>
        <Route path="/createPolicy" component={CreatePolicyContainer} />
        <Route path="/createPolicyHolder" component={CreatePolicyHolderContainer} />
        <Redirect from="/" to="/createPolicyHolder" />
      </Switch>
    </Container>
  </div>
);

export default RootRoutes;
