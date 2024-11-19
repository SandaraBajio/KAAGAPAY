package entities;

public class User {
    private String name;
    private String email;
    private String status;  // New field to store the status of the user (e.g., Available, Unavailable)

    // Constructor
    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.status = "Available";  // Default status
    }

    // Getter and Setter for name and email
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Overriding toString to include name and email
    @Override
    public String toString() {
        return name + " - " + email;
    }
}
