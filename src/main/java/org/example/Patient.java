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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    public LinkedList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(LinkedList<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateJoined=" + dateJoined +
                ", appointments=" + appointments +
                '}';
    }
}