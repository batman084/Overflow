package com.minilabs.jacob.lists;

public class Node {
    private Node next;
    private int data;

    public Node(int data) {
        this.data = data;
        next = null;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
}
