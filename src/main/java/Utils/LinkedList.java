package Utils;

import org.w3c.dom.Node;

 class LinkedList<Appointment> {

    private Node<Appointment> head;

    private Node<Appointment> tail;

    private int size;

    private static class Node<N> {
       N data;
       Node<N> next;

       Node(N data) {
          this.data = data;
          this.next = null;
       }
    }

    public LinkedList() {
       this.head = null;
       this.tail = null;
       this.size = 0;
    }

    /**
     * Returns the number of elements in the linked list
     *
     * @return The number of elements in the linked list
     */
    public int size() {
       return size;
    }

    /**
     * Checks if the linked list is empty
     *
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
       return size == 0;
    }

    /**
     * Adds an element to the end of the linked list
     *
     * @param data The data to be added
     */
    public void add(Appointment data) {
      Node<Appointment> newNode = new Node<>(data);
      if(isEmpty()) {
         head = newNode;
         tail = newNode;
      }
      else {
         tail.next = newNode;
         tail = newNode;
      }
      size++;

    }
    /**
     * Retrieves the element at the specified index in the linked list
     *
     * @param index The index of the element to retrieve
     * @return The element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public Appointment get(int index) {

       if (index < 0 || index >= size)
       {
          throw new IndexOutOfBoundsException("Out of bounds");
       }
       Node<Appointment> current = head;
       for (int i = 0; i < index; i++) {
          current = current.next;
       }
       return current.data;
    }

    /**
     * Removes the element at the specified index from the linked list
     *
     * @param index The index of the element to remove
     * @return The removed element
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */

    public Appointment remove(int index) {
          if (index < 0 || index >= size) {
             throw new IndexOutOfBoundsException("Index out of bounds");
          }

       Appointment DataToBeRemoved;
          if (index == 0) {
             DataToBeRemoved = head.data;
             head = head.next;
             if (head == null) {
                tail = null;
             }
          } else {
             Node<Appointment> before = head;
             for (int i = 0; i < index - 1; i++) {
                before = before.next;
             }
             DataToBeRemoved = before.next.data;
             before.next = before.next.next;
             if (before.next == null) {
                tail = before;
             }
          }
          size--;
          return DataToBeRemoved;
       }


    public void display()
    {

    }
    }
