package model.entitites;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.entitites.enums.PaymentMethods;

public class DocumentReceipt {

	public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private String nameProduct;
	private Integer id;
	private LocalDate issueDate;
	private PaymentMethods paymentMethods;
	private int installments;
	private double value;

	private List<PaymentReceiptCustomer> paymentReceiptCustomer = new ArrayList<>();
	private List<PaymentReceiptStore> paymentReceiptStore = new ArrayList<>();

	public DocumentReceipt(String nameProduct, Integer id, LocalDate issueDate, PaymentMethods paymentMethods,
			int installments, double value) {
		this.nameProduct = nameProduct;
		this.id = id;
		this.issueDate = issueDate;
		this.paymentMethods = paymentMethods;
		this.installments = installments;
		this.value = value;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public List<PaymentReceiptCustomer> getPaymentReceiptCustomer() {
		return paymentReceiptCustomer;
	}

	public List<PaymentReceiptStore> getPaymentReceiptStore() {
		return paymentReceiptStore;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("Recibos gerados com sucesso!\n");
		sb.append("\n");
		
		if (getPaymentMethods().name().equals("PIX")) {
			sb.append("VIA DO CLIENTE - Emitido - ").append(getIssueDate().format(fmt)).append("\n");
			sb.append("ID: ").append(getId()).append("\n");
			sb.append("Produto: ").append(getNameProduct()).append("\n");
			sb.append("Valor do produto: R$ ").append(String.format("%.2f",getValue())).append("\n");
			sb.append("Método de pagamento: ").append(getPaymentMethods().name()).append("\n");
			for (PaymentReceiptCustomer paycust : paymentReceiptCustomer) {
				sb.append("Valor Pago: R$ ").append(String.format("%.2f",paycust .getFullPayment()));
			}
			sb.append("\n");
			sb.append("-----------------------------------------------");
			sb.append("\n");
			sb.append("VIA DA LOJA - Emitido - ").append(getIssueDate().format(fmt)).append("\n");
			sb.append("ID: ").append(getId()).append("\n");
			sb.append("Produto: ").append(getNameProduct()).append("\n");
			sb.append("Valor do produto: R$ ").append(String.format("%.2f",getValue())).append("\n");
			sb.append("Método de pagamento: ").append(getPaymentMethods().name()).append("\n");
			for (PaymentReceiptCustomer paycust : paymentReceiptCustomer) {
				sb.append("Valor Pago: R$ ").append(String.format("%.2f",paycust.getFullPayment())).append("\n");
			}
			for (PaymentReceiptStore paystore : paymentReceiptStore) {
				sb.append("Valor recebido: R$ ").append(String.format("%.2f",paystore.getTotalReceived()));
			}
			return sb.toString();

		} 
		else {
			sb.append("VIA DO CLIENTE - Emitido - ").append(getIssueDate().format(fmt)).append("\n");
			sb.append("ID: ").append(getId()).append("\n");
			sb.append("Produto: ").append(getNameProduct()).append("\n");
			sb.append("Valor do produto: R$ ").append(String.format("%.2f",getValue())).append("\n");
			sb.append("Método de pagamento: ").append(getPaymentMethods().name()).append("\n");
			for (PaymentReceiptCustomer paycust : paymentReceiptCustomer) {
				sb.append("Parcelas: ").append(getInstallments()).append("x de R$ ")
				.append(String.format("%.2f",paycust.getInstallmentValue()));
				sb.append("\nValor Pago: R$ ").append(String.format("%.2f",paycust.getFullPayment()));
			}
			sb.append("\n");
			sb.append("-----------------------------------------------");
			sb.append("\n");
			sb.append("VIA DA LOJA - Emitido - ").append(getIssueDate().format(fmt)).append("\n");
			sb.append("ID: ").append(getId()).append("\n");
			sb.append("Produto: ").append(getNameProduct()).append("\n");
			sb.append("Valor do produto: R$ ").append(String.format("%.2f",getValue())).append("\n");
			sb.append("Método de pagamento: ").append(getPaymentMethods().name()).append("\n");
			for (PaymentReceiptCustomer paycust : paymentReceiptCustomer) {
				sb.append("Parcelas: ").append(getInstallments()).append("x de")
				.append(String.format("%.2f",paycust.getInstallmentValue()));
				sb.append("\nValor Pago: R$ ").append(String.format("%.2f",paycust.getFullPayment())).append("\n");
			}
			for (PaymentReceiptStore paystore : paymentReceiptStore) {
				sb.append("Valor recebido: R$ ").append(String.format("%.2f",paystore.getTotalReceived()));
			}
			return sb.toString();
		}
	}

}
