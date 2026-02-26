package model.services;

public class CreditCardPaymentService implements PaymentService{


	@Override
	public double authorize(double value, int installments) {
		double valueFinal = 0.0;
		switch(installments) {
		case 1:
			valueFinal =  value +  value * 0.02;
			break;
		case 2:	
			valueFinal =  value +  value * 0.03;
			break;
		case 3:	
			valueFinal = value +  value * 0.03;	
			break;
		}
		return valueFinal;
	}

}
