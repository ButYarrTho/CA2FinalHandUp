package org.example;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Random;

public class App {

    private static BoundedPriorityQueue[] queues;

    private static final Scanner scanner = new Scanner(System.in);
    private static final hashMap patientHashMap = new hashMap();
    private static final BoundedPriorityQueue priorityQueue = new BoundedPriorityQueue(10, "Dr. Joe");

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter the upper bound of the queue: ");
        int upperBound = kb.nextInt();
        kb.nextLine();

        System.out.print("Enter the doctors rostered for the day (seperate the doctors by comma please): ");
        String doctors = kb.nextLine();
        String[] doctorNames = doctors.split(",");

        queues = new BoundedPriorityQueue[doctorNames.length];

        // Initialize queues for each doctor
        for (int i = 0; i < doctorNames.length; i++) {
            queues[i] = new BoundedPriorityQueue(upperBound, doctorNames[i]);
        }

        boolean exit = false;
        while (!exit) {


            displaymenu(kb);
            int choice = kb.nextInt();
            kb.nextLine();
            switch (choice) {
                case 1:
                    addPatient(kb);
                    break;
                case 2:
                    deletePatient(kb);
                    break;
                case 3:
                    displayPatients();
                    break;
                case 4:
                    createAppointment(kb);
                    break;
                case 5:
                    callNextPatient(kb);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        kb.close();
    }

    private static void addPatient(Scanner kb) {
        System.out.println("Enter patient details:");
        System.out.print("First Name: ");
        String firstName = kb.nextLine();
        System.out.print("Last Name: ");
        String lastName = kb.nextLine();
        System.out.print("Date of Birth (YYYY-MM-DD): ");
        LocalDate dateOfBirth = LocalDate.parse(kb.nextLine());

        Patient newPatient = new Patient(firstName, lastName, dateOfBirth, LocalDate.now());
        String patientKey = patientHashMap.generateKey(newPatient); // Generate key based on patient details

        if (patientHashMap.containsKey(patientKey)) {
            System.out.println("Patient already exists.");
        } else {
            patientHashMap.put(newPatient); // Add patient to the hashmap
            System.out.println("Patient added successfully.");
        }
    }


    private static void deletePatient(Scanner kb) {
        System.out.println("Enter patient details to delete:");
        System.out.print("First Name: ");
        String firstName = kb.nextLine();
        System.out.print("Last Name: ");
        String lastName = kb.nextLine();
        System.out.print("Date of Birth (YYYY-MM-DD): ");
        LocalDate dateOfBirth = LocalDate.parse(kb.nextLine());

        Patient patientToDelete = new Patient(firstName, lastName, dateOfBirth, LocalDate.now());
        String patientKey = patientHashMap.getKey(patientToDelete);

        if (patientKey != null) {
            boolean removed = patientHashMap.remove(patientToDelete);

            if (removed) {
                handleDeletedPatientAppointments(patientToDelete);
                System.out.println("Patient deleted successfully.");
            } else {
                System.out.println("Failed to delete patient.");
            }
        } else {
            System.out.println("Patient not found.");
        }
    }

    private static void handleDeletedPatientAppointments(Patient deletedPatient) {
        LinkedList<Appointment> appointments = deletedPatient.getAppointments();
        if (appointments != null) {
            appointments.remove(appointments.size());
        }
    }

    private static void displayPatients() {
        System.out.println("List of Patients:");
        java.util.LinkedList<Patient>[] map = patientHashMap.getMap();
        if (map != null) {
            for (java.util.LinkedList<Patient> patients : map) {
                if (patients != null) {
                    for (Patient patient : patients) {
                        System.out.println(patient);
                    }
                }
            }
        }

    }

    private static void createAppointment(Scanner kb) {
        System.out.println("Enter appointment details:");
        System.out.print("Patient's First Name: ");
        String firstName = kb.nextLine();
        System.out.print("Patient's Last Name: ");
        String lastName = kb.nextLine();
        System.out.print("Patient's Date of Birth (YYYY-MM-DD): ");
        LocalDate dateOfBirth = LocalDate.parse(kb.nextLine());
        System.out.print("Issue: ");
        String issue = kb.nextLine();
        System.out.print("Appointment Date (YYYY-MM-DD): ");
        LocalDate appointmentDate = LocalDate.parse(kb.nextLine());

        int triageLevel = generateRandomTriageLevel();

        Patient patient = new Patient(firstName, lastName, dateOfBirth, LocalDate.now());

        patientHashMap.put(patient);

        Appointment appointment = new Appointment(firstName, lastName, dateOfBirth, issue, appointmentDate, triageLevel, "");

        java.util.LinkedList<Patient> patientList = patientHashMap.getValue(patientHashMap.generateKey(patient));
        if (patientList != null) {
            patientList.add(patient);
            System.out.println("Appointment created successfully for patient " + firstName + " " + lastName);
        } else {
            System.out.println("Failed to create appointment. Patient not found.");
        }

    }
    private static int generateRandomTriageLevel () {
        Random random = new Random();
        return random.nextInt(5) + 1;
    }

    private static void callNextPatient(Scanner kb) {
        System.out.print("Enter doctor's full name: ");
        String doctorFullName = kb.nextLine();

        for (java.util.LinkedList<Patient> patientList : patientHashMap.getMap()) {
            for (Patient patient : patientList) {
                LinkedList<Appointment> appointments = patient.getAppointments();
                for (int i = 0; i < appointments.size(); i++) {
                    Appointment appointment = appointments.get(i);
                    if (appointment.getDocFullName().equalsIgnoreCase(doctorFullName)) {
                        System.out.println("Next appointment for Doctor " + doctorFullName + ":");
                        System.out.println(appointment);
                        return;
                    }
                }
            }
        }
        System.out.println("No appointments found for Doctor " + doctorFullName);
    }




        private static void displaymenu (Scanner kb){
            System.out.println("\nMenu:");
            System.out.println("1. Add a new patient");
            System.out.println("2. Delete a patient");
            System.out.println("3. Display all patients");
            System.out.println("4. Create a new appointment for a patient");
            System.out.println("5. Call the next patient for a doctor");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
        }


}


