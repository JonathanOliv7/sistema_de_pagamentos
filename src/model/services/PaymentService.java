package model.services;

public interface PaymentService {
	
	double authorize(double value, int installments);
}
