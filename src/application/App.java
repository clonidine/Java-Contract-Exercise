package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class App {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data:");
		
		System.out.print("Number: ");
		Integer contractNumber = sc.nextInt();
		
		System.out.print("Date (dd/MM/yyyy): ");
		Date contractDate = simpleDateFormat.parse(sc.next());
		
		System.out.print("Contract value: ");
		double contractValue = sc.nextDouble();
		
		Contract contract = new Contract(contractNumber, contractDate, contractValue);
		
		System.out.print("Enter number of installments: ");
		int N = sc.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processContract(contract, N);
		
		System.out.println("Installments:");
		
		for (Installment installment : contract.getInstallments()) {
			System.out.println(installment);
		}
		sc.close();
	}

}
