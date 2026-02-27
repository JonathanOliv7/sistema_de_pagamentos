package model.entitites;

public class PaymentReceiptCustomer{

	private double installmentValue;
	private double fullPayment;
	
	public PaymentReceiptCustomer(double installmentValue, double fullPayment) {
		
		this.installmentValue = installmentValue;
		this.fullPayment = fullPayment;
	}

	public double getInstallmentValue() {
		return installmentValue;
	}
	
	public void setInstallmentValue(double installmentValue) {
		this.installmentValue = installmentValue;
	}
	
	public double getFullPayment() {
		return fullPayment;
	}
	
	public void setFullPayment(double fullPayment) {
		this.fullPayment = fullPayment;
	}

}
