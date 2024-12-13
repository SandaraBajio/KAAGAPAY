package db;

import entities.Mission;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class MissionDatabase {
    private Map<Integer, Mission> missionMap; // Stores mission data

    public MissionDatabase() {
        missionMap = new HashMap<>();
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

    // Fix for isMissionAvailable method
    public boolean isMissionAvailable(String missionName) {
        for (Mission mission : missionMap.values()) { // Changed to use missionMap instead of undefined missions
            if (mission.getMissionName().equalsIgnoreCase(missionName)) {
                return true;
            }
        }
        return false;
    }
}
