package model.entitites;

import java.time.LocalDate;

import model.entitites.enums.PaymentMethods;

public class PaymentReceipt extends Document{
	
	private double value;
	private PaymentMethods paymentMethods;
	private int installments;

	public PaymentReceipt(Integer id, LocalDate issueDate, double value, 
			PaymentMethods paymentMethods,int installments) {
		super(id, issueDate);
		this. value =  value;
		this.paymentMethods = paymentMethods;
		this.installments = installments;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public PaymentMethods getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(PaymentMethods paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	public int getInstallments() {
		return installments;
	}

	public void setInstallments(int installments) {
		this.installments = installments;
	}	
	
}
