import managers.*;
import db.*;
import ui.Menu;

public class Main {
    public static void main(String[] args) {
        // Create the necessary objects for the managers and databases
        MissionDatabase missionDatabase = new MissionDatabase(); 
        MissionManager missionManager = new MissionManager(missionDatabase);
        UserDatabase userDatabase = new UserDatabase(); // Create the UserDatabase object
        DonationManager donationManager = new DonationManager();
        DonationDatabase donationDatabase = new DonationDatabase();

        // Pass all the required parameters to the Menu constructor
        Menu menu = new Menu(missionDatabase, missionManager, userDatabase, donationManager, donationDatabase);
        menu.displayMainMenu();
    }
}
