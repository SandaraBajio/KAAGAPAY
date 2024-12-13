package managers;

import entities.Mission;
import entities.Donation;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private Map<Integer, Mission> missionMap; // Stores mission data
    private HashMap<String, String> users; // Stores username-password pairs for users
    private HashMap<String, String> admins; // Stores username-password pairs for admins
    private HashMap<String, String> volunteerInfo; // Stores volunteer information
    private HashMap<String, List<Donation>> donations;

    public Database() {
        missionMap = new HashMap<>();
        users = new HashMap<>();
        admins = new HashMap<>();
        volunteerInfo = new HashMap<>();
        donations = new HashMap<>();

        // Adding a built-in admin account
        admins.put("admin", "admin123");  // Built-in admin account
    }

    // Mission-related methods
    public void insertMission(Mission mission) {
        int missionId = missionMap.size() + 1; // Generate unique ID for mission
        mission.setMissionId(missionId);
        missionMap.put(missionId, mission);
    }

    public Mission getMissionByName(String name) {
        for (Mission mission : missionMap.values()) {
            if (mission.getMissionName().equalsIgnoreCase(name)) {
                return mission;
            }
        }
        return null; // Return null if mission is not found
    }

    public Collection<Mission> getAllMissions() {
        return missionMap.values();
    }

    public void updateMission(Mission mission) {
        missionMap.put(mission.getMissionId(), mission);
    }

    public void deleteMission(int missionId) {
        missionMap.remove(missionId);
    }

    public boolean addDonation(String donorName, Donation donation) {
        if (!donations.containsKey(donorName)) {
            donations.put(donorName, new ArrayList<>());
        }
        donations.get(donorName).add(donation);
        return true;
    }

    public List<Donation> getDonationsByDonor(String donorName) {
        return donations.getOrDefault(donorName, new ArrayList<>());
    }

    public List<Donation> getAllDonations() {
        List<Donation> allDonations = new ArrayList<>();
        for (List<Donation> donorDonations : donations.values()) {
            allDonations.addAll(donorDonations);
        }
        return allDonations;
    }

    // User-related methods
    public boolean addUser(String username, String password) {
        if (users.containsKey(username)) {
            return false; // Username already exists
        }
        users.put(username, password);
        return true;
    }

    public boolean loginUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    // Admin-related methods
    public boolean loginAdmin(String password) {
        return admins.containsKey("admin") && admins.get("admin").equals(password);
    }

    // Volunteer-related methods
    public boolean addVolunteerInfo(String username, String info) {
        volunteerInfo.put(username, info);
        return true;
    }

    public String getVolunteerInfo(String username) {
        return volunteerInfo.get(username);
    }

    // You can add more fields or methods as needed for other features in the future
}
