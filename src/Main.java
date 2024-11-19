import managers.*;
import java.util.Scanner;
import entities.Volunteer;

public class Main {
    private static VolunteerManager volunteerManager = new VolunteerManager();
    private static RescueOperationManager rescueOperationManager = new RescueOperationManager();
    private static DonationManager donationManager = new DonationManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Disaster Response Management System!");

        boolean exit = false;
        while (!exit) {
            System.out.println("\nPlease select your role:");
            System.out.println("1. Volunteer");
            System.out.println("2. Responder");
            System.out.println("3. Make a Donation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            int roleChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (roleChoice) {
                case 1:
                    handleVolunteerMenu(scanner);
                    break;
                case 2:
                    handleResponderMenu(scanner);
                    break;
                case 3:
                    handleDonationMenu(scanner);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    // Donation Menu
    private static void handleDonationMenu(Scanner scanner) {
        System.out.println("\n--- Donation Menu ---");
        System.out.println("1. Donate Money");
        System.out.println("2. Donate Goods");
        System.out.println("3. Go Back");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                donateMoney(scanner);
                break;
            case 2:
                donateGoods(scanner);
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    // Process Money Donation
    private static void donateMoney(Scanner scanner) {
        System.out.print("Enter amount to donate: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        donationManager.processMoneyDonation(amount);
        System.out.println("Thank you for your donation of $" + amount);
    }

    // Process Goods Donation
    private static void donateGoods(Scanner scanner) {
        System.out.print("Enter the type of goods you're donating: ");
        String goodsType = scanner.nextLine();
        System.out.print("Enter quantity of goods: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        donationManager.processGoodsDonation(goodsType, quantity);
        System.out.println("Thank you for donating " + quantity + " units of " + goodsType);
    }

    // Volunteer Menu
    private static void handleVolunteerMenu(Scanner scanner) {
    System.out.println("\n--- Volunteer Menu ---");
    System.out.println("1. View Assigned Rescue Operations");
    System.out.println("2. Mark Availability");
    System.out.println("3. Go Back");
    System.out.print("Enter your choice: ");
    int choice = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    switch (choice) {
        case 1:
            // Ask for volunteer name
            System.out.print("Enter your name: ");
            String volunteerName = scanner.nextLine();
            
            // Find the volunteer by name
            Volunteer volunteer = volunteerManager.findVolunteerByName(volunteerName);
            
            // If volunteer exists, display their assigned operations
            if (volunteer != null) {
                volunteerManager.displayAssignedOperations(volunteer);
            } else {
                System.out.println("Volunteer not found.");
            }
            break;
        case 2:
            // Mark availability for the volunteer
            System.out.print("Enter your name to mark as available: ");
            volunteerName = scanner.nextLine();
            volunteerManager.markAsAvailable(volunteerName);
            break;
        case 3:
            return;
        default:
            System.out.println("Invalid choice. Returning to main menu.");
    }
}


    // Responder Menu
    private static void handleResponderMenu(Scanner scanner) {
        System.out.println("\n--- Responder Menu ---");
        System.out.println("1. View Current Operations");
        System.out.println("2. View Assigned Tasks");
        System.out.println("3. Go Back");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                rescueOperationManager.viewAllRescueOperations();
                break;
            case 2:
                // Placeholder for viewing assigned tasks
                System.out.println("Assigned tasks will be displayed here.");
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }
}
