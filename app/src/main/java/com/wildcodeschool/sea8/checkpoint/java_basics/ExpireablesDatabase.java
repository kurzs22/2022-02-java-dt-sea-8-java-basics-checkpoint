package com.wildcodeschool.sea8.checkpoint.java_basics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExpireablesDatabase<E extends IExpireable> {
    private List<E> listOfExpireables = new ArrayList<>();

    public void addItem(E item) {
        // add a new item to the list
        listOfExpireables.add(item);
    }

    public void removeExpired() {
        // implement the neccessary function to delete all expired entries from the list
        for (int i = listOfExpireables.size()-1; i >= 0; i--) {
            if (listOfExpireables.get(i).isExpired())
                listOfExpireables.remove(i);
        }
    }

    public void sortByExpirationDate(boolean descending) {
        // sort the list by the expiration date of it's entries
        // hint: use a comparator and expiryDate()
        Comparator<E> compareByExpiryDate;

        if (descending) compareByExpiryDate = Comparator.comparing(E::expiryDate).reversed();
        else compareByExpiryDate = Comparator.comparing(E::expiryDate);
        
        listOfExpireables.sort(compareByExpiryDate);
    }

    public E getFirstEntry() {
        // Return first item in the list
        return listOfExpireables.get(0);
    }

    public E getLastEntry() {
        // Return last item in the list
        return listOfExpireables.get(listOfExpireables.size() - 1);
    }

    public List<E> getList() {
        return listOfExpireables;
    }

}
