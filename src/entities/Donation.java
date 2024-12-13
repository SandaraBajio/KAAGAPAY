package entities;

import java.util.Date;

public class Donation {
    private String donorName;
    private double monetaryAmount; // For monetary donations
    private DonationCategory itemCategory; // Using the enum for in-kind donations
    private double itemQuantity;   // Quantity of items donated
    private String description;    // Additional description or details about the donation
    private Date donationDate;     // New field to store the donation date

    public enum DonationCategory {
        FOOD, 
        CLOTHING, 
        MEDICAL_SUPPLIES, 
        HYGIENE_PRODUCTS;
    }

    // Constructor for monetary donations
    public Donation(String donorName, double monetaryAmount) {
        this.donorName = donorName;
        this.monetaryAmount = monetaryAmount;
        this.itemCategory = null; // No in-kind category for monetary donations
        this.itemQuantity = 0;
        this.description = "Monetary Donation";
        this.donationDate = new Date(); // Set the current date
    }

    // Constructor for in-kind donations
    public Donation(String donorName, DonationCategory itemCategory, double itemQuantity, String description) {
        this.donorName = donorName;
        this.monetaryAmount = 0; // No monetary value for in-kind donations
        this.itemCategory = itemCategory;
        this.itemQuantity = itemQuantity;
        this.description = description;
        this.donationDate = new Date(); // Set the current date
    }

    // Getters and Setters for each field
    public String getDonorName() {
        return donorName;
    }

    public double getMonetaryAmount() {
        return monetaryAmount;
    }

    public DonationCategory getItemCategory() {
        return itemCategory;
    }

    public double getItemQuantity() {
        return itemQuantity;
    }

    public String getDescription() {
        return description;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    @Override
    public String toString() {
        if (monetaryAmount > 0) {
            return donorName + " donated " + monetaryAmount + " as a monetary donation on " + donationDate.toString() + ".";
        } else {
            return donorName + " donated " + itemQuantity + " units of " + itemCategory + " (" + description + ") on " + donationDate.toString() + ".";
        }
    }
}
