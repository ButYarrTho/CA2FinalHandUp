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

    public Appointment(String patientFirstName, String patientLastName, LocalDate dateOfBirth, String issue, LocalDate date, int triageLevel, String docFullName) {
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.dateOfBirth = dateOfBirth;
        this.issue = issue;
        this.date = date;
        this.triageLevel = triageLevel;
        this.docFullName = docFullName;
    }
    public String getDocFullName() {
        return docFullName;
    }

    public void setDocFullName(String docFullName) {
        this.docFullName = docFullName;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTriageLevel() {
        return triageLevel;
    }

    public void setTriageLevel(int triageLevel) {
        this.triageLevel = triageLevel;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "patientFirstName='" + patientFirstName + '\'' +
                ", patientLastName='" + patientLastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", issue='" + issue + '\'' +
                ", date=" + date +
                ", triageLevel=" + triageLevel +
                ", docFullName='" + docFullName + '\'' +
                '}';
    }
}