package entities;

public class Volunteer extends User {
    private boolean isApprovedForMission;
    private String experience;

    // Constructor
    public Volunteer(String username, String password, String experience) {
        super(username, password); // Calls User constructor
        this.experience = experience;
        this.isApprovedForMission = false;
    }

    // Getter and Setter methods
    public boolean isApprovedForMission() {
        return isApprovedForMission;
    }

    public void setApprovedForMission(boolean approvedForMission) {
        isApprovedForMission = approvedForMission;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Volunteer: " + getUsername() + ", Experience: " + experience;
    }
}
