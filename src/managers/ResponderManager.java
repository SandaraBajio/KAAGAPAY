package managers;

import entities.Responder;
import entities.RescueOperation;
import java.util.ArrayList;
import java.util.List;

public class ResponderManager {
    private List<Responder> responders = new ArrayList<>();

    // Method to add a responder to the system
    public void addResponder(Responder responder) {
        responders.add(responder);
    }

    // Method to assign a responder to a rescue operation
    public void assignResponderToOperation(String responderName, RescueOperation operation) {
        for (Responder responder : responders) {
            if (responder.getName().equalsIgnoreCase(responderName) && responder.isAvailable()) {
                responder.assignOperation(operation);
                responder.setAvailable(false); // Responder becomes unavailable after being assigned
                System.out.println(responderName + " has been assigned to " + operation.getOperationName());
                return;
            }
        }
        System.out.println("Responder not available or not found.");
    }

    // Method to mark a responder as available again
    public void markResponderAsAvailable(String responderName) {
        for (Responder responder : responders) {
            if (responder.getName().equalsIgnoreCase(responderName)) {
                responder.setAvailable(true);
                System.out.println(responderName + " is now available.");
                return;
            }
        }
        System.out.println("Responder not found.");
    }

    // Method to display ongoing operations for responders
    public void displayResponderOperations() {
        System.out.println("\nAssigned Operations for Responders:");
        for (Responder responder : responders) {
            if (!responder.getAssignedOperations().isEmpty()) {
                System.out.println("Responder: " + responder.getName());
                for (RescueOperation operation : responder.getAssignedOperations()) {
                    System.out.println(" - " + operation.getOperationName() + " at " + operation.getLocation());
                }
            }
        }
    }

    // Method to display all responders and their details
    public void manageResponders() {
        System.out.println("\nManaging Responders:");
        for (Responder responder : responders) {
            System.out.println(" - " + responder.getName() + " | Available: " + responder.isAvailable() + " | Work Schedule: " + responder.getWorkSchedule());
        }
    }
}
