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

    public boolean isFull() {
        return size() >= maxSize;
    }

    public Appointment poll() {

        if (isEmpty()) {
            return null;
        }
        return remove(0);
    }

    public Appointment riskyPoll() throws NoSuchElementException {
        try {
            return poll();
        } catch (Exception e) {
            throw new NoSuchElementException("Exception occurred during poll operation: " + e.getMessage());
        }
    }

    public Appointment peek() {
        if (isEmpty()) {
            return null;
        }
        return get(0);
    }

    public Appointment riskyPeek() throws NoSuchElementException {
        try {
            return peek();
        } catch (Exception e) {
            throw new NoSuchElementException("Exception occurred during peek operation: " + e.getMessage());
        }
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
