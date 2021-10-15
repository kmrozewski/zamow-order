import React from 'react'
import { useHistory } from 'react-router-dom'
import { Container } from 'react-bootstrap'
import { createOrder } from '../api'
import OrderForm from './OrderForm'


export default function Order() {
  const history = useHistory()

  const handleSuccess = (response) => {
    history.push("/order/detail", {orderDetail: response})
  }

  const handleError = (response) => {
    history.push("/order/error")
  }

  return (
    <Container>
      <OrderForm createOrder={createOrder} onSuccess={handleSuccess} onError={handleError} />
    </Container>
  )
}