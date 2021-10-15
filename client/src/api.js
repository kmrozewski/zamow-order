import axios from 'axios'
import {API} from './const'

export const createOrder = async (order) => {
	try {
		const response = await axios.post(API + '/order/create', order)
		return response.data
	} catch (error) {
		return {
			isFailed: true
		}
	}
}