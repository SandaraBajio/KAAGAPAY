package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Disaster {
    private String disasterName;           // Name of the disaster
    private String disasterType;           // Type of disaster (e.g., Typhoon, Earthquake)
    private String location;               // Location affected by the disaster
    private String status;                 // Status of the disaster (e.g., Ongoing, Resolved)
    private String description;            // Detailed description of the disaster
    private Date occurrenceDate;           // Date when the disaster occurred
    private List<RescueOperation> rescueOperations; // List of rescue operations related to this disaster

    // Constructor
    public Disaster(String disasterName, String disasterType, String location, String status, String description) {
        this.disasterName = disasterName;
        this.disasterType = disasterType;
        this.location = location;
        this.status = status;
        this.description = description;
        this.occurrenceDate = new Date(); // Default to current date for occurrence
        this.rescueOperations = new ArrayList<>(); // Initialize the list of rescue operations
    }

    // Getter and Setter methods
    public String getDisasterName() {
        return disasterName;
    }

    public void setDisasterName(String disasterName) {
        this.disasterName = disasterName;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getOccurrenceDate() {
        return occurrenceDate;
    }

    public void setOccurrenceDate(Date occurrenceDate) {
        this.occurrenceDate = occurrenceDate;
    }

    public List<RescueOperation> getRescueOperations() {
        return rescueOperations;
    }

    // Method to add a rescue operation related to this disaster
    public void addRescueOperation(RescueOperation operation) {
        this.rescueOperations.add(operation);
    }

    // Method to list all rescue operations for this disaster
    public void listRescueOperations() {
        if (rescueOperations.isEmpty()) {
            System.out.println("No rescue operations associated with this disaster.");
        } else {
            System.out.println("Rescue Operations for " + disasterName + ":");
            for (RescueOperation operation : rescueOperations) {
                System.out.println("- " + operation.getOperationName() + " at " + operation.getLocation() + " [Status: " + operation.getStatus() + "]");
            }
        }
    }

    @Override
    public String toString() {
        return "Disaster [Name: " + disasterName + ", Type: " + disasterType + ", Location: " + location + 
               ", Status: " + status + ", Occurrence Date: " + occurrenceDate + ", Description: " + description + "]";
    }
}
