import org.example.Patient;
import org.example.hashMap;
import org.junit.Test;

import java.time.LocalDate;
import java.util.LinkedList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class HashMapTests {

    private org.example.hashMap hashMap;

    @Test
    public void testPutAndGet() {
        hashMap = new hashMap();

        // Initialize Patient
        Patient patient1 = new Patient("John", "Doe", LocalDate.of(1990, 5, 15), LocalDate.now());
        Patient patient2 = new Patient("Alice", "Johnson", LocalDate.of(1985, 8, 20), LocalDate.now());

        // put patients into hashmap
        hashMap.put(patient1);
        hashMap.put(patient2);

        // test size of hashmap
        assertEquals(2, hashMap.size());

        assertEquals(patient1, hashMap.get(patient1).get(0));
        assertEquals(patient2, hashMap.get(patient2).get(0));
    }

    @Test
    public void testRemove() {
        hashMap = new hashMap();

        Patient patient1 = new Patient("John", "Doe", LocalDate.of(1990, 5, 15), LocalDate.now());

        hashMap.put(patient1);

        // test if hashmap has patients
        assertTrue(hashMap.containsKey(patient1.getFirstName() + patient1.getLastName() + patient1.getDateOfBirth()));

        // test removing patient from the hashMap
        assertTrue(hashMap.remove(patient1));

        assertFalse(hashMap.containsKey(patient1.getFirstName() + patient1.getLastName() + patient1.getDateOfBirth()));
    }

    public void testGetValue() {
        hashMap = new hashMap();

        Patient patient1 = new Patient("John", "Doe", LocalDate.of(1990, 5, 15), LocalDate.now());
        Patient patient2 = new Patient("Alice", "Johnson", LocalDate.of(1985, 8, 20), LocalDate.now());

        hashMap.put(patient1);
        hashMap.put(patient2);

        LinkedList<Patient> value1 = hashMap.getValue(hashMap.generateKey(patient1));
        LinkedList<Patient> value2 = hashMap.getValue(hashMap.generateKey(patient2));
        assertNotNull(value1);
        assertNotNull(value2);
        assertTrue(value1.contains(patient1));
        assertTrue(value2.contains(patient2));

        LinkedList<Patient> value3 = hashMap.getValue("NonExistentKey");
        assertNull(value3);
    }

    @Test
    public void testGetKey() {
        hashMap = new hashMap();

        Patient patient = new Patient("John", "Doe", LocalDate.of(1990, 5, 15), LocalDate.now());

        hashMap.put(patient);

        String key = hashMap.getKey(patient);
        assertNotNull(key);
        assertEquals(hashMap.generateKey(patient), key);

        Patient nonExistentPatient = new Patient("Non", "Existent", LocalDate.of(2000, 1, 1), LocalDate.now());
        String nonExistentKey = hashMap.getKey(nonExistentPatient);
        assertNull(nonExistentKey);
    }

    @Test
    public void testContainsKey() {
        hashMap = new hashMap();

        Patient patient = new Patient("John", "Doe", LocalDate.of(1990, 5, 15), LocalDate.now());

        hashMap.put(patient);

        assertTrue(hashMap.containsKey(hashMap.generateKey(patient)));

        assertFalse(hashMap.containsKey("NonExistentKey"));
    }
}
