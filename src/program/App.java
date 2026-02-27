package program;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import model.entitites.DocumentReceipt;
import model.entitites.enums.PaymentMethods;
import model.services.CreditCardPaymentService;
import model.services.PaymentSystemService;
import model.services.PixPaymentService;

public class App {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
			int id = ThreadLocalRandom.current().nextInt(1, 2_000_000_001);
			System.out.print("Nome do produto: ");
			String nameProduct = sc.nextLine();
			System.out.print("Forma de pagamento(PIX, CREDITCARD): ");
			PaymentMethods method = PaymentMethods.valueOf(sc.next());
			
			int installments = 1;
			
			if(method.name().equals("CREDITCARD")) {
				System.out.print("Quantas parcelas: ");
				 installments = sc.nextInt();
				 
			}
			
			System.out.print("Qual valor do produto: ");
			double value = sc.nextDouble();
			
			
		DocumentReceipt receipt = new DocumentReceipt(nameProduct, id, LocalDate.now(), method, installments, value);
		
		if(method.name().equals("PIX")) {
			PaymentSystemService paymentSystemService = new PaymentSystemService(new PixPaymentService());
			paymentSystemService.generateReceipt(receipt);
			
			}else {
				PaymentSystemService paymentSystemService = new PaymentSystemService(new CreditCardPaymentService());
				paymentSystemService.generateReceipt(receipt);
		}
	
		System.out.println(receipt.toString());;
		sc.close();
	}
}
