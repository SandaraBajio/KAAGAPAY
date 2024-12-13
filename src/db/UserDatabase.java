package db;

import java.util.HashMap;
import entities.Volunteer;

public class UserDatabase {
    private HashMap<String, String> users; // Stores username-password pairs for users
    private HashMap<String, String> admins; // Stores username-password pairs for admins
    private HashMap<String, Volunteer> volunteerInfo; // Stores Volunteer objects by username

    public UserDatabase() {
        users = new HashMap<>();
        admins = new HashMap<>();
        volunteerInfo = new HashMap<>();

        // Adding a built-in admin account
        admins.put("admin", "admin123");  // Built-in admin account
    }

    // User-related methods
    public boolean addUser(String username, String password) {
        if (users.containsKey(username)) {
            return false; // Username already exists
        }
        users.put(username, password);
        return true;
    }

    public boolean loginUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    // Admin-related methods
    public boolean loginAdmin(String password) {
        return admins.containsKey("admin") && admins.get("admin").equals(password);
    }

    // Volunteer-related methods
    public boolean addVolunteerInfo(String username, Volunteer volunteer) {
        if (volunteerInfo.containsKey(username)) {
            return false; // Volunteer already exists
        }
        volunteerInfo.put(username, volunteer);
        return true;
    }

    public Volunteer getVolunteerByUsername(String username) {
        return volunteerInfo.get(username); // Returns the Volunteer object or null if not found
    }

    public boolean updateVolunteer(Volunteer updatedVolunteer) {
        String username = updatedVolunteer.getUsername();
        if (volunteerInfo.containsKey(username)) {
            volunteerInfo.put(username, updatedVolunteer); // Updates the volunteer information
            return true;
        }
        return false; // Volunteer not found
    }

    // New method to check if a username is already registered (for user and volunteer handling)
    public boolean isUserRegistered(String username) {
        return users.containsKey(username);
    }

    // Overloaded method to check for admin accounts as well
    public boolean isAdminRegistered(String username) {
        return admins.containsKey(username);
    }

    // For extending functionality in the future (optional)
    public HashMap<String, Volunteer> getAllVolunteerInfo() {
        return new HashMap<>(volunteerInfo); // Returns a copy of the volunteerInfo map
    }
}
