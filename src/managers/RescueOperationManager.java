package managers;

import entities.RescueOperation;
import entities.Volunteer;
import java.util.ArrayList;
import java.util.List;

public class RescueOperationManager {
    private List<RescueOperation> rescueOperations;

    // Constructor
    public RescueOperationManager() {
        this.rescueOperations = new ArrayList<>();
    }

    // Method to add a new rescue operation
    public void addRescueOperation(RescueOperation operation) {
        rescueOperations.add(operation);
        System.out.println("Rescue operation added: " + operation.getOperationName());
    }

    public RescueOperation getRescueOperationByName(String operationName) {
        for (RescueOperation operation : rescueOperations) {
            if (operation.getOperationName().equalsIgnoreCase(operationName)) {
                return operation;
            }
        }
        System.out.println("Rescue operation not found: " + operationName);
        return null;
    }

    
    // Method to view all rescue operations
    public void viewAllRescueOperations() {
        if (rescueOperations.isEmpty()) {
            System.out.println("No rescue operations available.");
        } else {
            System.out.println("List of Rescue Operations:");
            for (RescueOperation operation : rescueOperations) {
                System.out.println(operation);
            }
        }
    }

    // Method to find a rescue operation by its name
    public RescueOperation findRescueOperationByName(String name) {
        for (RescueOperation operation : rescueOperations) {
            if (operation.getOperationName().equalsIgnoreCase(name)) {
                return operation;
            }
        }
        System.out.println("Rescue operation not found: " + name);
        return null;
    }

    // Method to assign a volunteer to a rescue operation
    public void assignVolunteerToOperation(String operationName, Volunteer volunteer) {
        RescueOperation operation = findRescueOperationByName(operationName);
        if (operation != null) {
            operation.assignVolunteer(volunteer);
            System.out.println("Volunteer " + volunteer.getName() + " assigned to " + operationName);
        }
    }

    // Method to update the status of a rescue operation
    public void updateRescueOperationStatus(String operationName, String newStatus) {
        RescueOperation operation = findRescueOperationByName(operationName);
        if (operation != null) {
            operation.setStatus(newStatus);
            System.out.println("Status updated for " + operationName + " to: " + newStatus);
        }
    }

    // Method to search rescue operations by location
    public void searchRescueOperationsByLocation(String location) {
        List<RescueOperation> foundOperations = new ArrayList<>();
        for (RescueOperation operation : rescueOperations) {
            if (operation.getLocation().equalsIgnoreCase(location)) {
                foundOperations.add(operation);
            }
        }
        if (foundOperations.isEmpty()) {
            System.out.println("No rescue operations found in location: " + location);
        } else {
            System.out.println("Rescue operations in " + location + ":");
            for (RescueOperation op : foundOperations) {
                System.out.println(op);
            }
        }
    }

    // Method to remove or complete a rescue operation
    public void completeRescueOperation(String operationName) {
        RescueOperation operation = findRescueOperationByName(operationName);
        if (operation != null) {
            operation.setStatus("Completed");
            System.out.println("Rescue operation completed: " + operationName);
        }
    }
}
