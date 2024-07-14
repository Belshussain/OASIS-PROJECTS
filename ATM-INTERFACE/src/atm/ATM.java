package atm;

import java.util.Scanner;

public class ATM {
	private Bank bank;
	private Scanner scanner;
	private User currentUser;
	
	
	public ATM (Bank bank, Scanner scanner) {
		this.bank = bank;
		this.scanner = scanner;
	}
	
	public boolean authenticate(String userID, String userPin) {
		currentUser = bank.getUser(userID);
		return currentUser != null && currentUser.getUserPin().equals(userPin);
	}
	public void showMenu() {
		while(true) {
			System.out.println("ATM Menu:");
            System.out.println("1. Your Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
            case 1:
                showTransactionHistory();
                break;
            case 2:
                performWithdrawal();
                break;
            case 3:
                performDeposit();
                break;
            case 4:
                performTransfer();
                break;
            case 5:
                System.out.println("Exiting the ATM...Goodbye!");
                return;
            default:
                System.out.println("You have entered an option that is invalid. Try again.");
        }
		}
	}
	private void showTransactionHistory() {
		System.out.println("Your Transaction History: ");
		for (String transaction : currentUser.getTransactionHistory().getHistory()) {
			System.out.println(transaction);
		}
	}
	private void performWithdrawal() {
		System.out.println("Enter the amount you would like to withdraw: ");
		double amount = scanner.nextDouble();
		scanner.nextLine();
		
		if (currentUser.withdraw(amount)) {
			System.out.println("Your withdrawal has been successful!");
			
		} else {
			System.out.println("Your withdrawal was unsuccessful ):  ");
		}
	}
	
	
	private void performDeposit() {
		System.out.println("Enter the amount you would like to deposit: ");
		double amount = scanner.nextDouble();
		scanner.nextLine();
		
		currentUser.deposit(amount);
		System.out.println("Your deposit was successful (:  ");
	}
	
	private void performTransfer() {
		System.out.println("Please enter the recipient's User ID :  ");
		String recipientID = scanner.nextLine();
		System.out.println("Enter the transfer amount: ");
		double amount = scanner.nextDouble();
		scanner.nextLine();
		
		User recipient = bank.getUser(recipientID);
		if(recipientID!= null) {
			currentUser.transfer(recipient, amount);
			System.out.println("Your transfer was successful!");
		} else {
			System.out.println("Recipient was not found.");
		}
	}

	
}
