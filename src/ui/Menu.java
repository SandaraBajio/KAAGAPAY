package ui;

import managers.*;

import java.util.Scanner;

public class Menu {

    private Database database;
    private MissionManager missionManager;
    private VolunteerManager volunteerManager;
    private RescueOperationManager rescueOperationManager;
    private DonationManager donationManager;
    private Scanner scanner;

    public Menu(Database database,MissionManager missionManager, VolunteerManager volunteerManager, RescueOperationManager rescueOperationManager, DonationManager donationManager) {
        this.database = database;
        this.missionManager = missionManager;
        this.volunteerManager = volunteerManager;
        this.rescueOperationManager = rescueOperationManager;
        this.donationManager = donationManager;
        this.scanner = new Scanner(System.in);
    }

    public void displayMainMenu() {
        System.out.println("Welcome to the Disaster Response Management System!");
        boolean exit = false;
    
        while (!exit) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Sign Up");
            System.out.println("2. Log In as User");
            System.out.println("3. Log In as Admin");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
    
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (choice) {
                case 1:
                    handleSignUp();
                    break;
                case 2:
                    handleUserLogin();
                    break;
                case 3:
                    handleAdminLogin();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private void handleSignUp() {
        System.out.println("\n--- Sign Up ---");
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
    
        if (database.addUser(username, password)) {
            System.out.println("Sign-up successful! You can now log in.");
        } else {
            System.out.println("Username already exists. Please try a different username.");
        }
    }
    
    private void handleUserLogin() {
        System.out.println("\n--- Log In as User ---");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
    
        if (database.loginUser(username, password)) {
            System.out.println("User login successful! Welcome, " + username + ".");
            handleUserMenu();
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
    
    private void handleAdminLogin() {
        System.out.println("\n--- Log In as Admin ---");
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();
    
        if (database.loginAdmin(password)) {
            System.out.println("Admin login successful!");
            handleAdminMenu();
        } else {
            System.out.println("Invalid admin password. Access denied.");
        }
    }
    
    private void handleAdminMenu() {
        boolean backToMain = false;
    
        while (!backToMain) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Manage Missions");
            System.out.println("2. Manage Volunteers");
            System.out.println("3. Manage Rescue Operations");
            System.out.println("4. View Donation Reports");
            System.out.println("5. Go Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (choice) {
                case 1:
                    // Directly calling the existing methods for managing missions
                    System.out.println("\n--- Manage Missions ---");
                    System.out.println("1. Add Mission");
                    System.out.println("2. Delete Mission");
                    System.out.println("3. Update Mission Status");
                    System.out.println("4. View Missions");
                    System.out.println("5. Go Back");
                    System.out.print("Enter your choice: ");
                    int missionChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    
                    // Call the corresponding methods based on the user's input
                    switch (missionChoice) {
                        case 1:
                            missionManager.addMission(); // Calls your addMission() method
                            break;
                        case 2:
                            System.out.print("Enter the name of the mission to delete: ");
                            String missionToDelete = scanner.nextLine();
                            missionManager.deleteMission(missionToDelete); // Calls deleteMission() from MissionManager
                        break;
                        case 3:
                            System.out.print("Enter the name of the mission to update status:");
                            String missionToUpdate = scanner.nextLine();
                            System.out.print("Update status to (ongoing/completed):");
                            String updateStatus = scanner.nextLine();
                            missionManager.updateMissionStatus(missionToUpdate, updateStatus); // Calls your updateMissionStatus() method
                            break;
                        case 4:
                            missionManager.viewAllMission();
                            break;
                        case 5:
                            // If user chooses to go back, we simply return to the main menu
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 2:
                    System.out.println("Admin: Manage Volunteers functionality here.");
                    break;
                case 3:
                    System.out.println("Admin: Manage Rescue Operations functionality here.");
                    break;
                case 4:
                    System.out.println("Admin: Viewing donation reports.");
                    break;
                case 5:
                    backToMain = true; // Exit the loop to return to the main menu
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private void handleUserMenu() {
        boolean backToMain = false;
    
        while (!backToMain) {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. Volunteer");
            System.out.println("2. Responder");
            System.out.println("3. Make a Donation");
            System.out.println("4. Go Back");
            System.out.print("Enter your choice: ");
    
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (choice) {
                case 1:
                    System.out.println("User: Volunteer functionality here.");
                    break;
                case 2:
                    System.out.println("User: Responder functionality here.");
                    break;
                case 3:
                    System.out.println("User: Donation functionality here.");
                    break;
                case 4:
                    backToMain = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}  
