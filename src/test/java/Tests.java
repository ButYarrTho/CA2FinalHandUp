import AppData.Appointment;
import Utils.BoundedPriorityQueue;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class Tests {


    private BoundedPriorityQueue queue;

    @Test
    public void testOffer() {
        // Create appointments
        Appointment appointment1 = new Appointment("John", "Doe", LocalDate.of(1990, 5, 15), "Checkup", LocalDate.now(), 1, "Dr. Smith");
        Appointment appointment2 = new Appointment("Alice", "Johnson", LocalDate.of(1985, 8, 20), "Consultation", LocalDate.now(), 2, "Dr. Smith");

        assertTrue(queue.offer(appointment1));
        assertTrue(queue.offer(appointment2));

        assertFalse(queue.offer(new Appointment("Bob", "Smith", LocalDate.of(1975, 10, 10), "Follow-up", LocalDate.now(), 3, "Dr. Smith")));
    }

    @Test
    public void testRiskyOffer() {
        // Create appointments
        Appointment appointment1 = new Appointment("John", "Doe", LocalDate.of(1990, 5, 15), "Checkup", LocalDate.now(), 1, "Dr. Smith");
        Appointment appointment2 = new Appointment("Alice", "Johnson", LocalDate.of(1985, 8, 20), "Consultation", LocalDate.now(), 2, "Dr. Smith");

        assertTrue(queue.riskyOffer(appointment1));
        assertTrue(queue.riskyOffer(appointment2));

        assertFalse(queue.riskyOffer(new Appointment("Bob", "Smith", LocalDate.of(1975, 10, 10), "Follow-up", LocalDate.now(), 3, "Dr. Smith")));
    }

    @Test
    public void testPoll() {
        // Create appointments
        Appointment appointment1 = new Appointment("John", "Doe", LocalDate.of(1990, 5, 15), "Checkup", LocalDate.now(), 1, "Dr. Smith");

        queue.offer(appointment1);

        Appointment polledAppointment = queue.poll();

        assertEquals(appointment1, polledAppointment);
    }

    @Test
    public void testRiskyPoll() {
        // Create appointments
        Appointment appointment1 = new Appointment("John", "Doe", LocalDate.of(1990, 5, 15), "Checkup", LocalDate.now(), 1, "Dr. Smith");

        queue.offer(appointment1);

        Appointment polledAppointment = queue.riskyPoll();

        assertEquals(appointment1, polledAppointment);
    }

    @Test
    public void testPeek() {
        // Create appointments
        Appointment appointment1 = new Appointment("John", "Doe", LocalDate.of(1990, 5, 15), "Checkup", LocalDate.now(), 1, "Dr. Smith");

        queue.offer(appointment1);

        // Peek queue
        Appointment peekedAppointment = queue.peek();

        assertEquals(appointment1, peekedAppointment);
    }

    @Test
    public void testRiskyPeek() {
        // Create appointments
        Appointment appointment1 = new Appointment("John", "Doe", LocalDate.of(1990, 5, 15), "Checkup", LocalDate.now(), 1, "Dr. Smith");

        queue.offer(appointment1);

        // Peek queue
        Appointment peekedAppointment = queue.riskyPeek();

        assertEquals(appointment1, peekedAppointment);
    }

    @Test
    public void testIsFull() {
        // Initially, the queue should be empty
        assertFalse(queue.isFull());

        queue.offer(new Appointment("John", "Doe", LocalDate.of(1990, 5, 15), "Checkup", LocalDate.now(), 1, "Dr. Smith"));
        queue.offer(new Appointment("Alice", "Johnson", LocalDate.of(1985, 8, 20), "Consultation", LocalDate.now(), 2, "Dr. Smith"));
        queue.offer(new Appointment("Bob", "Smith", LocalDate.of(1975, 10, 10), "Follow-up", LocalDate.now(), 3, "Dr. Smith"));

        assertTrue(queue.isFull());
    }

    @Test
    public void testSize() {
        // Initially, the queue should have size 0
        assertEquals(0, queue.size());

        queue.offer(new Appointment("John", "Doe", LocalDate.of(1990, 5, 15), "Checkup", LocalDate.now(), 1, "Dr. Smith"));
        queue.offer(new Appointment("Alice", "Johnson", LocalDate.of(1985, 8, 20), "Consultation", LocalDate.now(), 2, "Dr. Smith"));

        assertEquals(2, queue.size());
    }

    @Test
    public void testIsEmpty() {
        // Initially, the queue should be empty
        assertTrue(queue.isEmpty());

        queue.offer(new Appointment("John", "Doe", LocalDate.of(1990, 5, 15), "Checkup", LocalDate.now(), 1, "Dr. Smith"));
        queue.offer(new Appointment("Alice", "Johnson", LocalDate.of(1985, 8, 20), "Consultation", LocalDate.now(), 2, "Dr. Smith"));

        assertFalse(queue.isEmpty());
    }
}
