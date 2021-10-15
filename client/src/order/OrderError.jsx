import React from 'react'
import { Alert, Button, Container } from 'react-bootstrap'

export default function OrderError() {
	return (
		<Container>
			<Alert variant={"danger"}>
				Something went wrong while creating an order
			</Alert>
			<Button href="/">Back</Button>
		</Container>
	)
}