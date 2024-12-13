package entities;

public class User {
    private String username;
    private String password;  // Password for authentication
    private boolean isAdmin;  // To differentiate admins from regular users

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.isAdmin = false;      // Default to non-admin user
    }

    // Getter and Setter methods
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    // Method to log in the user
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Overriding toString to include all details
    @Override
    public String toString() {
        return username;
    }
}
