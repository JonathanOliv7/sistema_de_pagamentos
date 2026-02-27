package model.services;

public class PixPaymentService  implements GeneratorPaymentService{
	
	@Override
	public double authorizeCustomer(double value, int installments) {
		return value;
	}

	@Override
	public double authorizeStore(double value, int installments) {
		return value - value * 0.01;
	}

}
