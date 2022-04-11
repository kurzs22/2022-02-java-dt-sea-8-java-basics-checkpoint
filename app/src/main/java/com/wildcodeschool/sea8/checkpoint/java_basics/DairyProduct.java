package com.wildcodeschool.sea8.checkpoint.java_basics;

import java.time.LocalDate;

public class DairyProduct implements IExpireable {
    private LocalDate dateProduced;
    private int daysUntilSpoiled;

    public DairyProduct(int daysUntilSpoiled) {
        this.dateProduced = LocalDate.now();
        this.daysUntilSpoiled = daysUntilSpoiled;
    }

    public DairyProduct(LocalDate dateProduced, int daysUntilSpoiled) {
        this.dateProduced = dateProduced;
        this.daysUntilSpoiled = daysUntilSpoiled;
    }

    @Override
    public boolean isExpired() {
        // Provide the neccessary check here
        return dateProduced.plusDays(daysUntilSpoiled).isBefore(LocalDate.now());
    }

    @Override
    public LocalDate expiryDate() {
        // Return the expiration date
        return dateProduced.plusDays(daysUntilSpoiled);
    }

    @Override
    public String toString() {
        return String.format("DairyProduct [Date Produced: \"%s\", Expiration Date: \"%s\"]", dateProduced, expiryDate());
    }
    
}
