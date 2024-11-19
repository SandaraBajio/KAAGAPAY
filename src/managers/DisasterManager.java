package managers;

import entities.Disaster;
import java.util.ArrayList;
import java.util.List;

public class DisasterManager {
    private List<Disaster> disasters;

    // Constructor
    public DisasterManager() {
        this.disasters = new ArrayList<>();
    }

    // Method to add a new disaster
    public void addDisaster(Disaster disaster) {
        disasters.add(disaster);
        System.out.println("Disaster added: " + disaster.getDisasterName());
    }

    // Method to view all disasters
    public void viewAllDisasters() {
        if (disasters.isEmpty()) {
            System.out.println("No disasters recorded.");
        } else {
            System.out.println("List of Disasters:");
            for (Disaster disaster : disasters) {
                System.out.println(disaster);
            }
        }
    }

    // Method to find a disaster by name
    public Disaster findDisasterByName(String name) {
        for (Disaster disaster : disasters) {
            if (disaster.getDisasterName().equalsIgnoreCase(name)) {
                return disaster;
            }
        }
        System.out.println("Disaster not found: " + name);
        return null;
    }

    // Method to update the status of a disaster
    public void updateDisasterStatus(String name, String newStatus) {
        Disaster disaster = findDisasterByName(name);
        if (disaster != null) {
            disaster.setStatus(newStatus);
            System.out.println("Disaster status updated for " + name + " to: " + newStatus);
        }
    }

    // Method to delete a disaster by name
    public void deleteDisaster(String name) {
        Disaster disaster = findDisasterByName(name);
        if (disaster != null) {
            disasters.remove(disaster);
            System.out.println("Disaster deleted: " + name);
        }
    }

    // Method to list rescue operations for a specific disaster
    public void listRescueOperationsForDisaster(String name) {
        Disaster disaster = findDisasterByName(name);
        if (disaster != null) {
            disaster.listRescueOperations();
        }
    }

    // Method to search disasters by type
    public void searchDisastersByType(String type) {
        List<Disaster> foundDisasters = new ArrayList<>();
        for (Disaster disaster : disasters) {
            if (disaster.getDisasterType().equalsIgnoreCase(type)) {
                foundDisasters.add(disaster);
            }
        }
        if (foundDisasters.isEmpty()) {
            System.out.println("No disasters found for type: " + type);
        } else {
            System.out.println("Disasters of type " + type + ":");
            for (Disaster d : foundDisasters) {
                System.out.println(d);
            }
        }
    }
}
