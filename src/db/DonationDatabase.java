package db;

import entities.Donation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DonationDatabase {
    private List<Donation> donations = new ArrayList<>();

    // In DonationDatabase.java
public boolean addDonation(Donation donation) {
    // Add the donation to the database (e.g., a list or file)
    donations.add(donation); // Assuming donations is a list
    return true; // Return true if donation is successfully added
}


    // Get donations by a specific donor
    public List<Donation> getDonationsByDonor(String donorName) {
        return donations.stream()
                .filter(d -> d.getDonorName().equalsIgnoreCase(donorName))
                .collect(Collectors.toList());
    }

    // Get all donations
    public List<Donation> getAllDonations() {
        return donations;
    }

    // Get total monetary donations
    public double getTotalMonetaryDonations() {
        return donations.stream()
                .filter(d -> d.getMonetaryAmount() > 0)  // Only sum monetary donations
                .mapToDouble(Donation::getMonetaryAmount)
                .sum();
    }

    // Withdraw a donation (for a specific amount)
    public boolean withdrawDonation(double amount) {
        double totalMonetary = getTotalMonetaryDonations();
        if (amount > totalMonetary) {
            return false; // Not enough funds
        }

        // Add a new donation entry for the withdrawal
        addDonation(new Donation("Admin", amount)); // Add a withdrawal as a donation
        return true; // Withdrawal successful
    }
}
