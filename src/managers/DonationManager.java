package managers;

import entities.Donation;
import java.util.ArrayList;
import java.util.List;

public class DonationManager {
    private List<Donation> donations;
    private double totalMonetaryDonations;
    private String donationGoal; // E.g., "Help us collect 1000 food packs for flood victims"
    private double goalProgress;

    public DonationManager() {
        donations = new ArrayList<>();
        totalMonetaryDonations = 0;
        goalProgress = 0;
    }

    // Add a monetary donation
    public void addMonetaryDonation(Donation donation) {
        donations.add(donation);
        totalMonetaryDonations += donation.getMonetaryAmount();
    }

    // Add an in-kind donation
    public void addInKindDonation(Donation donation) {
        donations.add(donation);
    }

    // Set a donation goal (for goods or funds)
    public void setDonationGoal(String goalDescription) {
        this.donationGoal = goalDescription;
        this.goalProgress = 0;  // reset progress
    }

    // Track the progress of donation goal
    public void updateGoalProgress(double progress) {
        this.goalProgress += progress;
    }

    // Get total monetary donations
    public double getTotalMonetaryDonations() {
        return totalMonetaryDonations;
    }

    // Get donation details
    public List<Donation> getDonations() {
        return donations;
    }

    // Get donation goal and progress
    public String getDonationGoal() {
        return donationGoal + " Progress: " + goalProgress;
    }

    // Display a summary of all donations
    public void displayAllDonations() {
        for (Donation donation : donations) {
            System.out.println(donation);
        }
    }

    public void processMoneyDonation(double amount) {
        // Logic to handle money donation (could save it to a database or print a receipt)
        System.out.println("Processing money donation of: $" + amount);
    }

    public void processGoodsDonation(String goodsType, int quantity) {
        // Logic to handle goods donation (e.g., adding to a donation list)
        System.out.println("Processing donation of " + quantity + " units of " + goodsType);
    }
}
