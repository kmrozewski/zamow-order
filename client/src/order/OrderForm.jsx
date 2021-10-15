import React, { useState, useEffect } from 'react'
import { Form, Button } from 'react-bootstrap'
import './orderForm.css'

export default function OrderForm(props) {
	const fields = ['email', 'quantity', 'promoCode']
	const [form, setForm] = useState(null)

	const handleSubmit = event => {
		event.preventDefault()
		setForm(Object.fromEntries(new Map(fields.map(field => [field, event.target.elements[field].value]))))
	}

	useEffect(() => {
		const fetchData = async () => {
			if (form != null) {
				const response = await props.createOrder(form)
				'isFailed' in response ? props.onError(response) : props.onSuccess(response)
			}
		}

		fetchData()
	}, [form, props])

	return (
		<Form onSubmit={handleSubmit}>
			<Form.Group>

				<Form.Label id="emailLbl">Email address</Form.Label>
				<Form.Control
					type="email"
					name="email"
					placeholder="name@example.com"
					required
				/>

				<Form.Label>Quantity</Form.Label>
				<Form.Control
					type="number"
					name="quantity"
					placeholder="quantity"
					min={1}
					max={1000}
					required
				/>

				<Form.Label>Promo code</Form.Label>
				<Form.Control
					type="text"
					name="promoCode"
					placeholder="enter promo code if you have it"
					pattern="[0-9]{2,8}"
				/>
			</Form.Group>
			<Button id="orderBtn" type="submit">Place order</Button>
		</Form>
	)
}