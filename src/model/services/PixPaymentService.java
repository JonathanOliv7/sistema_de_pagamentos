package model.services;

public class PixPaymentService  implements PaymentService{
	
	@Override
	public double authorize(double value, int installments) {
		return value + installments * 0;
	}

}
