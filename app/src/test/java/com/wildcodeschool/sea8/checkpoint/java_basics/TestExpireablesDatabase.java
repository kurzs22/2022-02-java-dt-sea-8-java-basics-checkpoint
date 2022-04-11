package com.wildcodeschool.sea8.checkpoint.java_basics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class TestExpireablesDatabase {
    @Test
    public void testExpireablesDatabase() {
        ExpireablesDatabase<IExpireable> database = new ExpireablesDatabase<>();

        Certificate c = new Certificate("SEA 8 Checkpoint ExpireablesDatabase Test", "Wild Code School", LocalDate.now().plusDays(7));
        database.addItem(c);
        DairyProduct eightDays = new DairyProduct(8);
        database.addItem(eightDays);
        DairyProduct fourDays = new DairyProduct(4);
        database.addItem(fourDays);
        Certificate expiredItem = new Certificate("SEA 8 Checkpoint ExpireablesDatabase Expired Item", "Wild Code School", LocalDate.now().minusDays(7));
        database.addItem(expiredItem);
        DairyProduct d = new DairyProduct(14);
        database.addItem(d);

        assertEquals(c, database.getFirstEntry(), String.format("%s should be the first item in the list.", c));
        assertEquals(d, database.getLastEntry(), String.format("%s should be the last item in the list.", c));

        assertTrue(database.getList().contains(expiredItem), "Expired item should be in the list before removing.");
        database.removeExpired();
        assertFalse(database.getList().contains(expiredItem), "Expired item should not be in the list after removing.");

        database.sortByExpirationDate(true);
        assertEquals(fourDays, database.getLastEntry(),
                String.format("%s should be the last item in the list after sorting.", fourDays));
    }
}
