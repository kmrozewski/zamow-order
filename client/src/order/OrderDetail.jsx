import React from 'react'
import { useLocation } from 'react-router-dom'
import { Container, Card, ListGroup } from 'react-bootstrap'

export default function OrderConfirmed() {
	const location = useLocation()
	const orderDetail = location.state.orderDetail

	return (
		<Container>
			<Card style={{ marginTop: '1rem' }}>
				<Card.Body>
					<Card.Title>Order {orderDetail.orderNumber}</Card.Title>
					<Card.Text>
					Thank you for purchasing our product. Below are order details:
					</Card.Text>
				</Card.Body>
				<ListGroup variant="flush">
					<ListGroup.Item>E-mail: {orderDetail.email}</ListGroup.Item>
					<ListGroup.Item>Quantity: {orderDetail.quantity}</ListGroup.Item>
					<ListGroup.Item>Discount: {orderDetail.discount}%</ListGroup.Item>
				</ListGroup>
			</Card>
		</Container>
	)
}