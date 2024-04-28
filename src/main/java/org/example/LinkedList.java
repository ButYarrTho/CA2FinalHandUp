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
       return false;
    }

    public void add(Appointment data) {
    }

    public Appointment get(int index) {

       return null;
    }

    public Appointment remove(int index) {

       return null;
    }

    public void display()
    {

    }
    }
