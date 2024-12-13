import managers.*;
import ui.Menu;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        MissionManager missionManager = new MissionManager(database);
        VolunteerManager volunteerManager = new VolunteerManager();
        RescueOperationManager rescueOperationManager = new RescueOperationManager();
        DonationManager donationManager = new DonationManager();

        Menu menu = new Menu(database, missionManager, volunteerManager, rescueOperationManager, donationManager);
        menu.displayMainMenu();
    }
}
