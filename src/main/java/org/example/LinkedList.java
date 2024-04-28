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

    public int size() {
       return size;
    }

    public boolean isEmpty() {
       return size == 0;
    }

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


    public void display()
    {

    }
    }
