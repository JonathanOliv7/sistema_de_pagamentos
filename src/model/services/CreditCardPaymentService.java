package model.services;

public class CreditCardPaymentService implements GeneratorPaymentService{

	@Override
	public double authorizeCustomer(double value, int installments) {
		double valueInstallment = 0.0;
		switch(installments) {
		case 1:
			valueInstallment =  value +  value * 0.01;
			break;
		case 2:	
			valueInstallment =  value +  value * 0.03;
			break;
		case 3:	
			valueInstallment = value + value * 0.07;	
			break;
		}
		return valueInstallment;
	}

	@Override
	public double authorizeStore(double value, int installments) {
		double valueReceipt = 0.0;
		switch(installments) {
		case 1:
			valueReceipt =  value -  value * 0.03;
			break;
		case 2:	
			valueReceipt =  value -  value * 0.06;
			break;
		case 3:	
			valueReceipt = value -  value * 0.11;	
			break;
		}
		return valueReceipt;
	}

}
