package entities;

import java.util.ArrayList;
import java.util.List;

public class Responder {
    private String name;
    private boolean available;
    private List<RescueOperation> assignedOperations;
    private String workSchedule; // Fixed work schedule (e.g., "9 AM to 5 PM")

    public Responder(String name, String workSchedule) {
        this.name = name;
        this.available = true; // Assume they are available initially
        this.assignedOperations = new ArrayList<>();
        this.workSchedule = workSchedule;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<RescueOperation> getAssignedOperations() {
        return assignedOperations;
    }

    public void assignOperation(RescueOperation operation) {
        this.assignedOperations.add(operation);
    }

    public String getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(String workSchedule) {
        this.workSchedule = workSchedule;
    }
}
