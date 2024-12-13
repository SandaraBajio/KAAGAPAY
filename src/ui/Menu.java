package ui;

import managers.*;
import db.*;
import entities.*;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {

    private MissionDatabase missionDatabase;
    private MissionManager missionManager;
    private UserDatabase userDatabase;
    private UserManager userManager;
    private DonationManager donationManager;
    private DonationDatabase donationDatabase;
    private Scanner scanner;

    public Menu(MissionDatabase missionDatabase, MissionManager missionManager, UserDatabase userDatabase, DonationManager donationManager, DonationDatabase donationDatabase) {
        this.missionDatabase = missionDatabase;
        this.missionManager = missionManager;
        this.userDatabase = userDatabase;
        this.userManager = new UserManager(userDatabase);
        this.donationManager = donationManager;
        this.donationDatabase = donationDatabase;
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

            try {
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
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.nextLine(); // Clear the buffer
            }
        }
    }

    private void handleSignUp() {
        System.out.println("\n--- Sign Up ---");
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        try {
            userManager.handleSignUp(username, password);
        } catch (Exception e) {
            System.out.println("An error occurred during sign-up. Please try again.");
        }
    }

    private void handleUserLogin() {
        System.out.println("\n--- Log In as User ---");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try {
            if (userManager.handleUserLogin(username, password)) {
                System.out.println("User login successful! Welcome, " + username + ".");
                handleUserMenu(username); // Pass the username for user-specific operations
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred during login. Please try again.");
        }
    }

    private void handleAdminLogin() {
        System.out.println("\n--- Log In as Admin ---");
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        try {
            if (userManager.handleAdminLogin(password)) {
                System.out.println("Admin login successful!");
                handleAdminMenu();
            } else {
                System.out.println("Invalid admin password. Access denied.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred during admin login. Please try again.");
        }
    }

    private void handleAdminMenu() {
        boolean backToMain = false;

        while (!backToMain) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Manage Missions");
            System.out.println("2. Manage Volunteers");
            System.out.println("3. Manage Donations");
            System.out.println("4. Go Back");
            System.out.print("Enter your choice: ");
            int choice = 0;

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        manageMissions();
                        break;
                    case 2:
                        manageVolunteers();
                        break;
                    case 3:
                        manageDonations();
                        break;
                    case 4:
                        backToMain = true; // Exit the loop to return to the main menu
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.nextLine(); // Clear the buffer
            }
        }
    }

    private void manageMissions() {
        System.out.println("\n--- Manage Missions ---");
        System.out.println("1. Add Mission");
        System.out.println("2. Delete Mission");
        System.out.println("3. Update Mission Status");
        System.out.println("4. View Missions");
        System.out.println("5. Go Back");
        System.out.print("Enter your choice: ");
        int missionChoice = 0;

        try {
            missionChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

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
                    System.out.print("Enter the name of the mission to update status: ");
                    String missionToUpdate = scanner.nextLine();
                    System.out.print("Update status to (ongoing/completed): ");
                    String updateStatus = scanner.nextLine();
                    missionManager.updateMissionStatus(missionToUpdate, updateStatus); // Calls your updateMissionStatus() method
                    break;
                case 4:
                    missionManager.viewAllMission();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid option.");
            scanner.nextLine(); // Clear the buffer
        }
    }

    private void manageVolunteers() {
        System.out.println("\n--- Manage Volunteers ---");
        System.out.println("1. Approve Volunteer Mission");
        System.out.println("2. Show Volunteer Profile");
        System.out.println("3. Go Back");
        System.out.print("Enter your choice: ");
        int choice = 0;

        try {
            choice = scanner.nextInt();
            scanner.nextLine(); // To consume the newline character after integer input

            switch (choice) {
                case 1:
                    // Approve Volunteer Mission
                    System.out.print("Enter Volunteer Username to approve for mission: ");
                    String username = scanner.nextLine();
                    Volunteer volunteer = userDatabase.getVolunteerByUsername(username);
                    if (volunteer != null) {
                        approveVolunteerForMission(volunteer);
                    } else {
                        System.out.println("Volunteer not found.");
                    }
                    break;

                case 2:
                    // Show Volunteer Profile
                    System.out.print("Enter Volunteer Username to view profile: ");
                    username = scanner.nextLine();
                    volunteer = userDatabase.getVolunteerByUsername(username);
                    if (volunteer != null) {
                        showVolunteerProfile(volunteer);
                    } else {
                        System.out.println("Volunteer not found.");
                    }
                    break;

                case 3:
                    // Go back to the previous menu
                    System.out.println("Returning to previous menu...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    manageVolunteers(); // Recurse to allow retry
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid option.");
            scanner.nextLine(); // Clear the buffer
        }
    }

    private void approveVolunteerForMission(Volunteer volunteer) {
        if (!volunteer.isApprovedForMission()) {
            volunteer.setApprovedForMission(true);
            userDatabase.updateVolunteer(volunteer); // Update volunteer info in the database
            System.out.println("Volunteer " + volunteer.getUsername() + " has been approved for the mission.");
        } else {
            System.out.println("Volunteer " + volunteer.getUsername() + " is already approved for the mission.");
        }
    }

    private void showVolunteerProfile(Volunteer volunteer) {
        // Display the volunteer's full profile
        System.out.println("\n--- Volunteer Profile ---");
        System.out.println("Username: " + volunteer.getUsername());
        System.out.println("Approved for Mission: " + (volunteer.isApprovedForMission() ? "Yes" : "No"));
        System.out.println("Experience: " + volunteer.getExperience());
    }

    private void manageDonations() {
        boolean backToDonationsMenu = false;
        while (!backToDonationsMenu) {
            System.out.println("\n--- Manage Donations ---");
            System.out.println("1. View Total Donations");
            System.out.println("2. Withdraw Donation with Purpose");
            System.out.println("3. Go Back");
            System.out.print("Enter your choice: ");
            int choice = 0;

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        viewTotalDonations();
                        break;
                    case 2:
                        withdrawDonation();
                        break;
                    case 3:
                        backToDonationsMenu = true; // Exit the loop to return to the main menu
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Clear the buffer
            }
        }
    }

    public void viewTotalDonations() {
        try {
            double totalDonations = donationManager.getTotalMonetaryDonations();
            System.out.println("Total Monetary Donations: $" + totalDonations);
        } catch (Exception e) {
            System.out.println("Error retrieving donation data.");
        }
    }

    public void withdrawDonation() {
        System.out.print("Enter the purpose for the withdrawal: ");
        String purpose = scanner.nextLine();

        // Ask for the withdrawal amount
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        try {
            boolean success = donationDatabase.withdrawDonation(amount);
            if (success) {
                System.out.println("Withdrawal of $" + amount + " for the purpose of '" + purpose + "' completed.");
            } else {
                System.out.println("Insufficient funds for this withdrawal.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred during the withdrawal. Please try again.");
        }
    }

    private void handleUserMenu(String username) {
        boolean backToMain = false;

        while (!backToMain) {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. Be a Volunteer");
            System.out.println("2. Make a Donation");
            System.out.println("3. Go Back");
            System.out.print("Enter your choice: ");
            int choice = 0;

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        becomeVolunteer(username);
                        break;
                    case 2:
                        handleDonation(username);
                        break;
                    case 3:
                        backToMain = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Clear the buffer
            }
        }
    }

    private void becomeVolunteer(String username) {
        System.out.println("\n--- Become a Volunteer ---");
    
        // Check if the user is already a volunteer
        if (userDatabase.getVolunteerByUsername(username) != null) {
            System.out.println("You are already a volunteer.");
            return;
        }
    
        // Ask the user for their name (no experience input as per the new requirement)
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
    
        // Display available missions (missions entered by admin)
        System.out.println("\nAvailable Missions:");
        missionManager.viewAllMission(); // Assuming this method displays all the missions
    
        System.out.print("Please choose a mission by entering its name: ");
        String missionName = scanner.nextLine();
    
        // Check if the mission exists
        if (!missionDatabase.isMissionAvailable(missionName)) {
            System.out.println("Mission not found.");
            return;
        }
    
        // Create the volunteer object with "pending" status for mission approval
        Volunteer volunteer = new Volunteer(username, userDatabase.getVolunteerByUsername(username).getPassword(), "");
        volunteer.setApprovedForMission(false); // Initially not approved
        volunteer.setExperience(name); // Use name as a placeholder (or you can extend this for a more meaningful attribute)
    
        if (userDatabase.addVolunteerInfo(username, volunteer)) {
            System.out.println("You have successfully registered as a volunteer for the mission: " + missionName);
            System.out.println("Your volunteering status is pending until approval by the admin.");
        } else {
            System.out.println("There was an issue registering you as a volunteer.");
        }
    }
    
    private void handleDonation(String username) {
        System.out.println("\n--- Make a Donation ---");
    
        // Ask for the donation amount
        System.out.print("Please enter the amount you want to donate: ");
        double donationAmount = 0;
        boolean validAmount = false;
    
        // Validate the donation amount
        while (!validAmount) {
            try {
                donationAmount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
    
                if (donationAmount <= 0) {
                    System.out.println("Donation amount must be greater than zero. Please try again.");
                } else {
                    validAmount = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid donation amount.");
                scanner.nextLine(); // Clear the buffer
            }
        }
    
        // Process the donation
        Donation donation = new Donation(username, donationAmount);

        if (donationDatabase.addDonation(donation)) {
            System.out.println("Thank you for your donation of $" + donationAmount + "!");
        } else {
            System.out.println("There was an issue processing your donation. Please try again later.");
        }
    }
    

    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
