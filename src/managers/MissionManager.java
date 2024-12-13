package managers;

import entities.Mission;
import java.util.Scanner;

public class MissionManager {
    private Database database;

    public MissionManager(Database database) {
        this.database = database;
    }

    public void viewAllMission() {
        database.getAllMissions().forEach(mission -> System.out.println(mission));
    }

    public Mission findMissionByName(String name) {
        return database.getMissionByName(name);
    }

    public void updateMissionStatus(String name, String newStatus) {
        Mission mission = findMissionByName(name);
        if (mission != null) {
            mission.setStatus(Mission.MissionStatus.valueOf(newStatus.toUpperCase()));
            database.updateMission(mission);
            System.out.println("Mission status updated for " + name + " to: " + newStatus);
        }
    }

    public void deleteMission(String name) {
        Mission mission = findMissionByName(name);
        if (mission != null) {
            database.deleteMission(mission.getMissionId());
            System.out.println("Mission deleted: " + name);
        }
    }

    public void addMission() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter mission name: ");
        String name = scanner.nextLine();

        System.out.println("Enter mission type (e.g., EARTHQUAKE, TYPHOON, FIRE, etc.): ");
        String typeInput = scanner.nextLine();
        Mission.MissionType type = Mission.MissionType.valueOf(typeInput.toUpperCase());

        System.out.println("Enter location: ");
        String location = scanner.nextLine();

        System.out.println("Enter mission status (ONGOING or COMPLETED): ");
        String statusInput = scanner.nextLine();
        Mission.MissionStatus status = Mission.MissionStatus.valueOf(statusInput.toUpperCase());

        System.out.println("Enter description: ");
        String description = scanner.nextLine();

        Mission newMission = new Mission(name, type, location, status, description);

        database.insertMission(newMission);
        System.out.println("New mission successfully added!");
    }
}
