package org.example;
import java.time.LocalDate;
import java.util.Scanner;


public class App {

    private static BoundedPriorityQueue[] queues;

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
            System.out.println("\nMenu:");
            System.out.println("1. Add a new patient");
            System.out.println("2. Delete a patient");
            System.out.println("3. Display all patients");
            System.out.println("4. Create a new appointment for a patient");
            System.out.println("5. Call the next patient for a doctor");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
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

    }

