package atm;

public class User {
    private String userID;
    private String userPin;
    private double balance;
    private TransactionHistory transactionHistory;
    
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
    
    public TransactionHistory getTransactionHistory() {
        return transactionHistory;
    }
    
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.addTransactionHistory("Withdraw: " + amount);
            return true;
        }
        return false;
    }
    
    public void deposit(double amount) {
        balance += amount;
        transactionHistory.addTransactionHistory("Deposit: " + amount);
    }
    
    public void transfer(double amount, User recipient) {
        if (recipient == null) {
            System.out.println("Recipient not found. Please check the User ID.");
            return;
        }
        if (this.balance >= amount) {
            this.withdraw(amount);
            recipient.deposit(amount);
            transactionHistory.addTransactionHistory("Transfer to " + recipient.getUserID() + ": " + amount);
            recipient.getTransactionHistory().addTransactionHistory("Transfer from " + this.getUserID() + ": " + amount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
