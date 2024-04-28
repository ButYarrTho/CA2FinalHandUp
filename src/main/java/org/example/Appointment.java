package org.example;
import java.time.LocalDate;

public class Appointment {

    String patientFirstName;
    String patientLastName;
    LocalDate dateOfBirth;
    String issue;
    LocalDate date;
    int triageLevel;
    String docFullName;

    public String getDocFullName() {
        return docFullName;
    }

    public void setDocFullName(String docFullName) {
        this.docFullName = docFullName;
    }

    public Appointment(String patientFirstName, String patientLastName, LocalDate dateOfBirth, String issue, LocalDate date, int triageLevel, String docFullName) {
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.dateOfBirth = dateOfBirth;
        this.issue = issue;
        this.date = date;
        this.triageLevel = triageLevel;
        this.docFullName = docFullName;
    }

}