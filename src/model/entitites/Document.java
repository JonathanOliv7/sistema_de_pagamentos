package model.entitites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Document {

	protected Integer id;
	protected LocalDate issueDate;
	private List<PaymentReceipt> paymentReceipt = new ArrayList<>();
	

	public Document(Integer id, LocalDate issueDate) {
		this.id = id;
		this.issueDate = issueDate;
	}

	public List<PaymentReceipt> getPaymentReceipt() {
		return paymentReceipt;
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

}
