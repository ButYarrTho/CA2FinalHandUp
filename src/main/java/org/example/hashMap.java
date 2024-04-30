package org.example;
import java.util.LinkedList;

/**
 * HashMap is a data structure that stores key-value pairs. It provides constant-time performance for basic operations
 * such as adding, removing, and retrieving elements.
 */
public class hashMap {
    private static final int DEFAULT_CAPACITY = 103;

    private int size;
    private int capacity;
    private LinkedList<Patient>[] map;

    public hashMap() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs a new HashMap with the specified capacity.
     *
     * @param DEFAULT_CAPACITY The initial capacity of the HashMap.
     */
    public hashMap(int DEFAULT_CAPACITY) {
        this.capacity = DEFAULT_CAPACITY;
        this.map = new LinkedList[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Generates a unique key for the given Patient object based on first name, last name, and date of birth.
     *
     * @param patient The Patient object for which the key is generated.
     * @return The generated key.
     */
    public String generateKey(Patient patient) {
        return patient.getFirstName() + patient.getLastName() + patient.getDateOfBirth();
    }

    private int hashFunction(String key) {
        int slot = Math.abs(key.hashCode());
        return slot % capacity;
    }

    /**
     * Adds a Patient object to the HashMap.
     *
     * @param patient The Patient object to be added.
     */
    public void put(Patient patient) {
        if (patient == null)
            return;
        int index = hashFunction(generateKey(patient));
        if (map[index] == null) {
            map[index] = new LinkedList<>();
        }

        for (Patient p : map[index]) {
            if (p.equals(patient)) {
                return;
            }
        }
        map[index].add(patient);
        size++;
    }

    /**
     * Retrieves the LinkedList of patients associated with the given Patient object from the HashMap.
     *
     * @param patient The Patient object used to retrieve the associated LinkedList.
     * @return The LinkedList of patients associated with the given Patient object, or null if not found.
     */
    public LinkedList<Patient> get(Patient patient) {
        if (patient == null)
            return null;

        int index = hashFunction(generateKey(patient));
        LinkedList<Patient> bucket = map[index];
        if (bucket != null) {
            for (Patient p : bucket) {
                if (p.equals(patient)) {
                    return bucket;
                }
            }
        }
        return null;
    }

    /**
     * Removes the specified Patient object from the HashMap.
     *
     * @param patient The Patient object to be removed.
     * @return true if the removal is successful, false otherwise.
     */
    public boolean remove(Patient patient) {
        if (patient == null)
            return false;

        int index = hashFunction(generateKey(patient));
        LinkedList<Patient> bucket = map[index];
        if (bucket != null) {
            for (Patient p : bucket) {
                if (p.equals(patient)) {
                    bucket.remove(p);
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the HashMap contains the specified key.
     *
     * @param key The key to check for existence in the HashMap.
     * @return true if the key is found, false otherwise.
     */
    public boolean containsKey(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int index = hashFunction(key);
        LinkedList<Patient> array = map[index];
        if (array != null) {
            for (Patient patient : array) {
                if (generateKey(patient).equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Retrieves the key associated with the specified Patient object from the HashMap.
     *
     * @param patient The Patient object for which to retrieve the key.
     * @return The key associated with the specified Patient object, or null if not found.
     */
    public String getKey(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null");
        }

        String patientKey = generateKey(patient);
        int index = hashFunction(patientKey);
        LinkedList<Patient> array = map[index];
        if (array != null) {
            for (Patient p : array) {
                if (generateKey(p).equals(patientKey)) {
                    return patientKey;
                }
            }
        }
        return null;
    }

    /**
     * Retrieves the value associated with the specified key from the HashMap.
     *
     * @param key The key for which to retrieve the value.
     * @return The value associated with the specified key, or null if not found.
     */
    public LinkedList<Patient> getValue(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int index = hashFunction(key);
        LinkedList<Patient> array = map[index];
        if (array != null) {
            for (Patient patient : array) {
                if (generateKey(patient).equals(key)) {
                    return array;
                }
            }
        }
        return null;
    }

    public LinkedList<Patient>[] getMap() {
        return map;
    }

    /**
     * Returns the number of elements currently stored in the hashmap.
     *
     * @return The number of elements in the hashmap.
     */
    public int size() {
        return size;
    }
}