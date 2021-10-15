import React, { Suspense } from 'react'
import { BrowserRouter as Router, Switch, Route, Redirect } from 'react-router-dom'
import { Spinner } from 'react-bootstrap'

const Order = React.lazy(() => import('./order/Order'))
const OrderDetail = React.lazy(() => import('./order/OrderDetail'))
const OrderError = React.lazy(() => import('./order/OrderError'))

export default function App() {
  return (
    <Router>
      <Suspense fallback={<Spinner animation="border" />}>
        <Switch>
          <Route path="/order">
            <Route path={"/order/create"} exact component={Order}/>
            <Route path={"/order/detail"} exact component={OrderDetail}/>
            <Route path={"/order/error"} exact component={OrderError}/>
            <Redirect from="/order" to="/order/create" exact/>
          </Route>
          <Route path={"/"} exact component={Order}/>
          <Redirect to={"/"}/>
        </Switch>
      </Suspense>
    </Router>
  )
}
