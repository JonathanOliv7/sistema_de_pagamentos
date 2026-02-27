package model.services;

import model.entitites.DocumentReceipt;
import model.entitites.PaymentReceiptCustomer;
import model.entitites.PaymentReceiptStore;

public class PaymentSystemService {
	
	private GeneratorPaymentService generatorPaymentService;

	public PaymentSystemService(GeneratorPaymentService generatorPaymentService) {
		this.generatorPaymentService = generatorPaymentService;
	}

	public void generateReceipt(DocumentReceipt document) {
		double basicInstallment = document.getValue()/document.getInstallments();
		double installmentValue = generatorPaymentService.authorizeCustomer(basicInstallment, document.getInstallments());
		double totalValue = generatorPaymentService.authorizeCustomer(document.getValue(), document.getInstallments());
		double amountReceived = generatorPaymentService.authorizeStore(totalValue,document.getInstallments() );
		
		document.getPaymentReceiptCustomer().add(new PaymentReceiptCustomer(installmentValue, totalValue));
		document.getPaymentReceiptStore().add(new PaymentReceiptStore(amountReceived));
	}
}
