package entities;

public class Donation {
    private String donorName;
    private double monetaryAmount; // For monetary donations
    private String itemCategory;   // For in-kind donations (e.g., Food, Clothing)
    private double itemQuantity;   // Quantity of items donated
    private String description;    // Additional description or details about the donation

    // Constructor for monetary donations
    public Donation(String donorName, double monetaryAmount) {
        this.donorName = donorName;
        this.monetaryAmount = monetaryAmount;
        this.itemCategory = "Monetary"; // Default for monetary donations
        this.itemQuantity = 0;
        this.description = "Monetary Donation";
    }

    // Constructor for in-kind donations
    public Donation(String donorName, String itemCategory, double itemQuantity, String description) {
        this.donorName = donorName;
        this.monetaryAmount = 0; // No monetary value for in-kind donations
        this.itemCategory = itemCategory;
        this.itemQuantity = itemQuantity;
        this.description = description;
    }

    // Getters and Setters for each field
    public String getDonorName() {
        return donorName;
    }

    public double getMonetaryAmount() {
        return monetaryAmount;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public double getItemQuantity() {
        return itemQuantity;
    }

    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        if (monetaryAmount > 0) {
            return donorName + " donated " + monetaryAmount + " as a monetary donation.";
        } else {
            return donorName + " donated " + itemQuantity + " units of " + itemCategory + " (" + description + ").";
        }
    }
}
