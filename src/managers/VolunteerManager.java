package managers;

import entities.RescueOperation;
import entities.Volunteer;
import java.util.ArrayList;
import java.util.List;

public class VolunteerManager {
    private List<Volunteer> volunteers;

    // Constructor
    public VolunteerManager() {
        this.volunteers = new ArrayList<>();
    }

    // Method to register a new volunteer
    public void registerVolunteer(Volunteer volunteer) {
        volunteers.add(volunteer);
        System.out.println("Volunteer registered: " + volunteer.getName());
    }

    // Method to view all registered volunteers
    public void viewAllVolunteers() {
        if (volunteers.isEmpty()) {
            System.out.println("No volunteers registered.");
        } else {
            System.out.println("List of Volunteers:");
            for (Volunteer volunteer : volunteers) {
                System.out.println(volunteer);
            }
        }
    }

    // Method to find a volunteer by name
    public Volunteer findVolunteerByName(String name) {
        for (Volunteer volunteer : volunteers) {
            if (volunteer.getName().equalsIgnoreCase(name)) {
                return volunteer;
            }
        }
        System.out.println("Volunteer not found: " + name);
        return null;
    }

    // Method to update volunteer availability
    public void updateVolunteerAvailability(String name, boolean isAvailable) {
        Volunteer volunteer = findVolunteerByName(name);
        if (volunteer != null) {
            volunteer.setAvailable(isAvailable);
            String status = isAvailable ? "Available" : "Unavailable";
            System.out.println(volunteer.getName() + " is now marked as " + status);
        }
    }

    // Method to assign a volunteer to a rescue operation
    public void assignVolunteerToOperation(Volunteer volunteer, RescueOperationManager rescueOperationManager, String operationName) {
        if (volunteer.isAvailable()) {
            RescueOperation operation = rescueOperationManager.getRescueOperationByName(operationName);
            if (operation != null) {
                volunteer.assignToRescueOperation(operation);  // Using the assignToRescueOperation method of Volunteer class
            } else {
                System.out.println("Operation " + operationName + " not found.");
            }
        } else {
            System.out.println("Volunteer " + volunteer.getName() + " is not available.");
        }
    }

    // Method to remove a volunteer from the system
    public void removeVolunteer(String name) {
        Volunteer volunteer = findVolunteerByName(name);
        if (volunteer != null) {
            volunteers.remove(volunteer);
            System.out.println("Volunteer removed: " + name);
        }
    }

    // Method to display all assigned operations for a volunteer
    public void displayAssignedOperations(Volunteer volunteer) {
        if (volunteer != null) {
            RescueOperation assignedOp = volunteer.getAssignedOperation();
            if (assignedOp == null) {
                System.out.println(volunteer.getName() + " has no assigned operations.");
            } else {
                System.out.println("Assigned Rescue Operation for " + volunteer.getName() + ":");
                System.out.println(assignedOp);  // Display the assigned operation
            }
        }
    }

    // Method to mark a volunteer as available
    public void markAsAvailable(String volunteerName) {
        Volunteer volunteer = findVolunteerByName(volunteerName);
        if (volunteer != null) {
            volunteer.setStatus("Available");
            volunteer.setAvailable(true);
            System.out.println(volunteerName + " is now available.");
        } else {
            System.out.println("Volunteer not found.");
        }
    }
}
