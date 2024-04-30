
package Utils;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void testSize() {
        LinkedList<String> list = new LinkedList<>();
        assertEquals(0, list.size());

        list.add("One");
        assertEquals(1, list.size());

        list.add("Two");
        assertEquals(2, list.size());
    }

    @Test
    public void testIsEmpty() {
        LinkedList<String> list = new LinkedList<>();
        assertTrue(list.isEmpty());

        list.add("One");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testAddAndGet() {
        LinkedList<String> list = new LinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        assertEquals("One", list.get(0));
        assertEquals("Two", list.get(1));
        assertEquals("Three", list.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBounds() {
        LinkedList<String> list = new LinkedList<>();
        list.get(0);
    }

    @Test
    public void testRemove() {
        LinkedList<String> list = new LinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        assertEquals("Two", list.remove(1));
        assertEquals(2, list.size());
        assertEquals("Three", list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBounds() {
        LinkedList<String> list = new LinkedList<>();
        list.remove(0);
    }
}
