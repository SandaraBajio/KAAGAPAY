package entities;
import java.util.ArrayList;
import java.util.List;

public class RescueOperation {
    private String operationName;
    private String location;
    private String status; // e.g., "Ongoing", "Completed", "Pending"
    private List<Volunteer> assignedVolunteers;

    // Constructor
    public RescueOperation(String operationName, String location, String status) {
        this.operationName = operationName;
        this.location = location;
        this.status = status;
        this.assignedVolunteers = new ArrayList<>();
    }

    // Getters and Setters
    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Volunteer> getAssignedVolunteers() {
        return assignedVolunteers;
    }

    // Method to assign a volunteer to this rescue operation
    public void assignVolunteer(Volunteer volunteer) {
        if (volunteer != null && volunteer.isAvailable()) {
            assignedVolunteers.add(volunteer);
            volunteer.setAvailable(false); // Mark volunteer as unavailable after assignment
            System.out.println("Volunteer " + volunteer.getName() + " assigned to " + operationName);
        } else {
            System.out.println("Volunteer is not available or is null.");
        }
    }

    // Method to display details of the rescue operation
    public void displayOperationDetails() {
        System.out.println("Operation Name: " + operationName);
        System.out.println("Location: " + location);
        System.out.println("Status: " + status);
        System.out.println("Assigned Volunteers:");
        for (Volunteer v : assignedVolunteers) {
            System.out.println("- " + v.getName());
        }
    }
}
