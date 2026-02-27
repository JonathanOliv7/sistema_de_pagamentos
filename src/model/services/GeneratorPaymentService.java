package model.services;

public interface GeneratorPaymentService {
	
	double authorizeCustomer(double value, int installments);
	double authorizeStore(double value, int installments);
}
