package org.example;

import org.w3c.dom.Node;

 class LinkedList<appoinments> {

    private Node<appoinments> head;

    private Node<appoinments> tail;

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
     * Returns the number of elements in the list
     * @return The size of the list
     */
    public int size() {
       return size;
    }

    /**
     * Checks if the list is empty
     * @return True if the list is empty false otherwise
     */
    public boolean isEmpty() {
       return size == 0;
    }

    /**
     * Adds a new appointment to the end of the list
     * @param data The appointment to be added
     */
    public void add(appoinments data) {
      Node<appoinments> newNode = new Node<>(data);
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
     * Retrieves the appointment at the specified index in the list
     * @param index The index of the appointment to retrieve
     * @return The appointment at the specified index
     * @throws IndexOutOfBoundsException If the index is out of bounds
     */
    public appoinments get(int index) {

       if (index < 0 || index >= size)
       {
          throw new IndexOutOfBoundsException("Out of bounds");
       }
       Node<appoinments> current = head;
       for (int i = 0; i < index; i++) {
          current = current.next;
       }
       return current.data;
    }


    /**
     * Removes the appointment at the specified index from the list
     * @param index The index of the appointment to remove
     * @return The removed appointment
     * @throws IndexOutOfBoundsException If the index is out of bounds
     */
    public appoinments remove(int index) {
          if (index < 0 || index >= size) {
             throw new IndexOutOfBoundsException("Index out of bounds");
          }

       appoinments DataToBeRemoved;
          if (index == 0) {
             DataToBeRemoved = head.data;
             head = head.next;
             if (head == null) {
                tail = null;
             }
          } else {
             Node<appoinments> before = head;
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

    /**
     * Displays all appointments in the list.
     */
    public void display()
    {
       Node<appoinments> current = head;
       while (current != null) {
          System.out.println(current.data);
          current = current.next;
       }
    }
    }
