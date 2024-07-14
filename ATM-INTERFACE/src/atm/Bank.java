package atm;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, User> users;
    
    public Bank() {
        users = new HashMap<>(); 
        users.put("user00", new User("user00", "1111"));
        users.put("user02", new User("user02", "2222")); //recipient
    }
    
    public User getUser(String userID) {
        return users.get(userID);
    }
}
