package atm;

import java.util.HashMap;
import java.util.Map;

public class Bank {
	private Map<String, User> users;
	
	public Bank() {
		users = new HashMap<>(); 
		users.put("user00", new User("user00", "1111"));
	}
	
	public User getUser(String userID) {
		return users.get(userID);
	}

}
