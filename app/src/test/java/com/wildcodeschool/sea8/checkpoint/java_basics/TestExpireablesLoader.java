package com.wildcodeschool.sea8.checkpoint.java_basics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class TestExpireablesLoader {
    @Test
    public void testExpireablesLoader() {
        ExpireablesDatabase<IExpireable> database = ExpireablesLoader.loadExpireablesFromFile(new File("src/test/resources/expireables.csv"));
        assertEquals(8, database.getList().size(), "There should be eight entries in the list.");
        boolean found = false;
        for (IExpireable expireable : database.getList()) {
            if (!found)
                found = expireable.expiryDate().equals(LocalDate.parse("2022-06-18"));
            else
                break;
        }
        assertTrue(found, "The entry with the expiration date of 2022-06-18 should be loaded from file and therefore be in the list.");
    }
}
