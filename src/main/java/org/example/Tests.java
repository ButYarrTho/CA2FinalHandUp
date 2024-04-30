package org.example;

import org.junit.Test;

import java.time.LocalDate;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class Tests {
    private hashMap hashMap; // Use your custom hashMap class

    @Test
    public void testPutAndGet() {
        // Initialize the hashMap
        hashMap = new hashMap();

        // Initialize Patient instances
        Patient patient1 = new Patient("John", "Doe", LocalDate.of(1990, 5, 15), LocalDate.now());
        Patient patient2 = new Patient("Alice", "Johnson", LocalDate.of(1985, 8, 20), LocalDate.now());

        // Test putting patients into the hashMap
        hashMap.put(patient1);
        hashMap.put(patient2);

        // Test size of the hashMap
        assertEquals(2, hashMap.size());

        // Test getting patients from the hashMap
        assertEquals(patient1, hashMap.get(patient1).get(0));
        assertEquals(patient2, hashMap.get(patient2).get(0));
    }

    @Test
    public void testRemove() {
        // Initialize the hashMap
        hashMap = new hashMap();

        // Initialize Patient instance
        Patient patient1 = new Patient("John", "Doe", LocalDate.of(1990, 5, 15), LocalDate.now());

        // Test putting patient into the hashMap
        hashMap.put(patient1);

        // Test if the hashMap contains the patient
        assertTrue(hashMap.containsKey(patient1.getFirstName() + patient1.getLastName() + patient1.getDateOfBirth()));

        // Test removing patient from the hashMap
        assertTrue(hashMap.remove(patient1));

        // Test if the hashMap no longer contains the patient
        assertFalse(hashMap.containsKey(patient1.getFirstName() + patient1.getLastName() + patient1.getDateOfBirth()));
    }
}
