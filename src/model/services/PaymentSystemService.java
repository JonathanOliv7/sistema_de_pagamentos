package model.services;

import model.entitites.Document;

public class PaymentSystemService {
	
	private PaymentService  payment;

	public PaymentSystemService(PaymentService payment) {
		this.payment = payment;
	}

	public PaymentService getPayment() {
		return payment;
	}

	public void setPayment(PaymentService payment) {
		this.payment = payment;
	}
	public void processReceipt(Document document, int installments) {
		
	}
}
