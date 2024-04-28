package org.example;

import java.time.LocalDate;

/**
 * Represents a patient with associated appointments.
 */
public class Patient {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private LocalDate dateJoined;
    private LinkedList<Appointment> appointments;

    public Patient(String firstName, String lastName, LocalDate dateOfBirth, LocalDate dateJoined) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateJoined = dateJoined;
        this.appointments = new LinkedList<>();
    }


}