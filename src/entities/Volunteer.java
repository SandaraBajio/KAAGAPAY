package entities;

public class Volunteer extends User {
    private String skills;
    private boolean isAvailable;
    private String volunteerType;  // Nimbus Basic, Nimbus Plus, etc.
    private RescueOperation assignedOperation;  // Reference to assigned rescue operation (if any)

    // Constructor
    public Volunteer(String name, String email, String skills, boolean isAvailable, String volunteerType) {
        super(name, email);
        this.skills = skills;
        this.isAvailable = isAvailable;
        this.volunteerType = volunteerType;
        this.assignedOperation = null;  // Initially not assigned to any operation
    }

    // Getter and Setter methods for skills, isAvailable, volunteerType, and assignedOperation
    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getVolunteerType() {
        return volunteerType;
    }

    public void setVolunteerType(String volunteerType) {
        this.volunteerType = volunteerType;
    }

    public RescueOperation getAssignedOperation() {
        return assignedOperation;
    }

    public void setAssignedOperation(RescueOperation assignedOperation) {
        this.assignedOperation = assignedOperation;
    }

    // Method to assign a volunteer to a rescue operation
    public void assignToRescueOperation(RescueOperation operation) {
        if (this.isAvailable) {
            this.assignedOperation = operation;
            this.isAvailable = false;  // Mark as unavailable once assigned
            System.out.println(this.getName() + " has been assigned to " + operation.getOperationName());
        } else {
            System.out.println(this.getName() + " is not available for this operation.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " - Skills: " + skills + " - Available: " + isAvailable + " - Volunteer Type: " + volunteerType;
    }
}
