package managers;

import java.util.HashMap;

public class UserManager {
    private HashMap<String, String> users; // Stores username-password pairs

    public UserManager() {
        users = new HashMap<>();
    }

    // Sign up a new user
    public boolean signUp(String username, String password) {
        if (users.containsKey(username)) {
            return false; // Username already exists
        }
        users.put(username, password);
        return true;
    }

    // Log in an existing user
    public boolean login(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
