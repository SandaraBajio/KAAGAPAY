package managers;

import db.UserDatabase;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private UserDatabase userDatabase;
    private Map<String, String> userStatuses; // To store user statuses

    public UserManager(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
        this.userStatuses = new HashMap<>(); // Initialize the statuses map
    }

    // Sign up a new user
    public void handleSignUp(String username, String password) {
        if (userDatabase.addUser(username, password)) {
            System.out.println("Sign-up successful! You can now log in.");
        } else {
            System.out.println("Username already exists. Please try a different username.");
        }
    }

    // Handle user login
    public boolean handleUserLogin(String username, String password) {
        return userDatabase.loginUser(username, password);
    }

    // Handle admin login
    public boolean handleAdminLogin(String password) {
        return userDatabase.loginAdmin(password);
    }

    // Update the status of a user
    public boolean updateUserStatus(String username, String status) {
        if (username == null || status == null) {
            return false;  // Return false if username or status is null
        }
        userStatuses.put(username, status);
        System.out.println("Status for " + username + " updated to " + status + ".");
        return true;  // Return true if the update was successful
    }

    // Retrieve the status of a user
    public String getUserStatus(String username) {
        return userStatuses.getOrDefault(username, "Unknown");  // Return "Unknown" if the user doesn't have a status
    }
}
