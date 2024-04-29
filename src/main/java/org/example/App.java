package org.example;
import java.time.LocalDate;
import java.util.Scanner;
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

    private static void addPatient(Scanner kb){
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




    private static void deletePatient(Scanner kb){

    }

    private static void displayPatients() {

    }

    private static void createAppointment(Scanner kb) {

        }


    private static void callNextPatient(Scanner kb) {

    }

    private static void displaymenu(Scanner kb){
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

