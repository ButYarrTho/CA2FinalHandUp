package org.example;
import java.time.LocalDate;

public class Appointment {

    String patientFirstName;
    String patientLastName;
    LocalDate dateOfBirth;
    String issue;
    LocalDate date;
    int triageLevel;
    String doctorFullName;

    public Appointment(String patientFirstName, String patientLastName, LocalDate dateOfBirth, String issue, LocalDate date, int triageLevel, String doctorFullName) {
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.dateOfBirth = dateOfBirth;
        this.issue = issue;
        this.date = date;
        this.triageLevel = triageLevel;
        this.doctorFullName = doctorFullName;
    }
}