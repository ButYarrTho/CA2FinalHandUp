package org.example;

/**
 * HashMap is a data structure that stores key-value pairs. It provides constant-time performance for basic operations
 * such as adding, removing, and retrieving elements.
 */
public class HashMap {
    private static final int DEFAULT_CAPACITY = 103;

    private int size;
    private int capacity;
    private LinkedList<Patient>[] map;

    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs a new HashMap with the specified capacity.
     *
     * @param capacity The initial capacity of the HashMap.
     */
    public HashMap(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedList[capacity];
        this.size = 0;
    }

    /**
     * Generates a unique key for the given Patient object based on first name, last name, and date of birth.
     *
     * @param patient The Patient object for which the key is generated.
     * @return The generated key.
     */
    private String generateKey(Patient patient) {
        return patient.getFirstName() + patient.getLastName() + patient.getDateOfBirth();
    }


    }