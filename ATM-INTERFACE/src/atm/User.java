package atm;

//import java.util.ArrayList;

public class User {
	private String userID;  //will store the users ID
	private String userPin; //will store the users PIN
	private double balance; // will store users current balance
	private TransactionHistory transactionHistory;  //Stores users transaction history
	
	public User(String userID, String userPin) {
		this.userID = userID;
		this.userPin = userPin;
		this.balance = 0.0;
		this.transactionHistory = new TransactionHistory();
		
	}
	
	public String getUserID() {
		return userID;
	}
	
	public String getUserPin() {
		return userPin;
	}
	public double getBalance() {
		return balance;
	}
	public void deposit(double amount) {
		balance += amount;  //whatever the users balance is, plus the amount deposited
		transactionHistory.addTransactionHistory("You have deposited : " + amount); //shows how much money was deposited
	}
	public boolean withdraw(double amount) {
		if (amount<= balance) {
			balance -= amount;
			transactionHistory.addTransactionHistory("You have withdrew: " + amount);
			return true;
		}else {
			return false;
		}
	}
	public void transfer(User recipient, double amount) {
		if(withdraw(amount)) {
			recipient.deposit(amount);
			transactionHistory.addTransactionHistory("You have transferred : " + amount);
		}
	}
	public TransactionHistory getTransactionHistory() {
		return transactionHistory;
	}

}
