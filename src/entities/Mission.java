package entities;

import java.util.Date;

public class Mission {
    private int missionId;               
    private String missionName;           
    private MissionType missionType;    
    private String location;               
    private MissionStatus status;        
    private String description;            
    private Date occurrenceDate;           

    public enum MissionType {
        EARTHQUAKE, TYPHOON, FIRE, FLOOD, VOLCANIC_ERUPTION, LANDSLIDE, TSUNAMI
    }

    public enum MissionStatus {
        ONGOING, COMPLETED
    }

    public Mission(String missionName, MissionType missionType, String location, MissionStatus status, String description) {
        this.missionName = missionName;
        this.missionType = missionType;
        this.location = location;
        this.status = status;
        this.description = description;
        this.occurrenceDate = new Date(); }

    public int getMissionId() {
        return missionId;
    }

    public void setMissionId(int missionId) {
        this.missionId = missionId;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public MissionType getMissionType() {
        return missionType;
    }

    public void setMissionType(MissionType missionType) {
        this.missionType = missionType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public MissionStatus getStatus() {
        return status;
    }

    public void setStatus(MissionStatus status) {
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

    @Override
    public String toString() {
        return "Mission [ID: " + missionId + ", Name: " + missionName + ", Type: " + missionType + ", Location: " + location + 
               ", Status: " + status + ", Occurrence Date: " + occurrenceDate + ", Description: " + description + "]";
    }
}
