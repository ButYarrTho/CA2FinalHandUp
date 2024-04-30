package org.example;

import java.util.NoSuchElementException;

public class BoundedPriorityQueue extends LinkedList<Appointment> {
    private int maxSize;
    private String docFullName;


    public BoundedPriorityQueue (int maxSize, String docFullName ) {
        super();
        this.maxSize = maxSize;
        this.docFullName = docFullName;
    }

    /**
     * Offers an appointment to the queue The appointment is added if the queue is not full and
     * the appointment's doctor's full name matches the queue's doctor's full name
     *
     * @param appointment The appointment to be added
     * @return true if the appointment was added successfully false otherwise
     */
    public boolean offer(Appointment appointment) {
        if (!appointment.getDocFullName().equalsIgnoreCase(docFullName)) {
            return false;
        }
        if (size() < maxSize) {
            add(appointment);
            return true;
        }
        return false;
    }

    /**
     * Offers an appointment to the queue throwing an exception if an error occurs during the operation
     *
     * @param appointment The appointment to be added
     * @return true if the appointment was added successfully false otherwise
     * @throws IllegalStateException if an error occurs during the offer operation
     */
    public boolean riskyOffer(Appointment appointment) throws IllegalStateException  {
        try {
            if (!appointment.getDocFullName().equalsIgnoreCase(docFullName)) {
                return false;
            }
            add(appointment);
            return true;
        } catch (Exception e) {
            throw new IllegalStateException("Exception occurred during offer operation: " + e.getMessage());
        }
    }
    /**
     * Checks if the queue is full
     *
     * @return true if the queue is full false otherwise
     */
    public boolean isFull() {
        return size() >= maxSize;
    }

    /**
     * gets and removes the head of the queue or returns null if the queue is empty
     *
     * @return The head of the queue, or null if the queue is empty
     */
    public Appointment poll() {

        if (isEmpty()) {
            return null;
        }
        return remove(0);
    }

    /**
     * gets and removes the head of the queue, throwing an exception if the queue is empty
     *
     * @return The head of the queue
     * @throws NoSuchElementException if the queue is empty
     */

    public Appointment riskyPoll() throws NoSuchElementException {
        try {
            return poll();
        } catch (Exception e) {
            throw new NoSuchElementException("Exception occurred during poll operation: " + e.getMessage());
        }
    }

    /**
     * gets but does not remove the head of the queue or returns null if the queue is empty
     *
     * @return The head of the queue or null if the queue is empty
     */
    public Appointment peek() {
        if (isEmpty()) {
            return null;
        }
        return get(0);
    }

    /**
     * get but does not remove the head of the queue throwing an exception if the queue is empty
     *
     * @return The head of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public Appointment riskyPeek() throws NoSuchElementException {
        try {
            return peek();
        } catch (Exception e) {
            throw new NoSuchElementException("Exception occurred during peek operation: " + e.getMessage());
        }
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public String getDocFullName() {
        return docFullName;
    }

    public void setDocFullName(String docFullName) {
        this.docFullName = docFullName;
    }

    @Override
    public int size() {
        return super.size() > maxSize ? maxSize : super.size();

    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty() || super.size() >= maxSize;
    }

    public void clear() {
    }
}
