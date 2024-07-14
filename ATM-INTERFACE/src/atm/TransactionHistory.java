package atm;

import java.util.ArrayList;

public class TransactionHistory {
	private ArrayList<String> history;
	
	
	public TransactionHistory() {
		this.history = new ArrayList<>();
	}
	public void addTransactionHistory(String transaction) {
		history.add(transaction);
	}
	public ArrayList<String> getHistory(){
		return history;
	}
	

}
