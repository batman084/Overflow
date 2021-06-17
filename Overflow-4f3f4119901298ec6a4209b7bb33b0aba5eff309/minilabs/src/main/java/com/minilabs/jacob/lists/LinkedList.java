package com.minilabs.jacob.lists;

import java.util.*;

public class LinkedList {
    private Node head;
    private int count;

    public LinkedList() {
        this.head = null;
        this.count = 0;
    }

    public int getCount() {
        return this.count;
    }

    public void addHead(int data) {

        // change head to the new item
        Node newHead = new Node(data);

        // if the existing head is null, then there is no next
        newHead.setNext(this.head);
        this.head = newHead;
        this.count++;
    }

    public void addTail(int data) {

        Node newNode = new Node(data);
        Node tail = getTail();

        if (tail == null) {
            // no tail, so set the head
            this.head = newNode;
        } else {
            // found tail, so set the new node as the tail
            tail.setNext(newNode);
        }

        this.count++;
    }

    public void addAt(int data, int index) {

        if (index == 0) {
            // special case: insert at the head
            addHead(data);
        } else {
            // find the element before the requested position
            Node nodeBefore = getNodeAt(index - 1);

            // expecting it's not null
            Node newNode = new Node(data);

            // set next for the new node to whatever the "node before" was pointing to
            newNode.setNext(nodeBefore.getNext());
            // set "node before" to the next new node
            nodeBefore.setNext(newNode);
            this.count++;
        }
    }

    public int getAt(int index) {
        Node nodeBefore = getNodeAt(index);
        return nodeBefore.getData();
    }

    public void removeAt(int index) {

        if (index == 0) {

            // special case, remove head by setting it to its next
            this.head = this.head.getNext();
        } else {
            Node nodeBefore = getNodeAt(index - 1);
            Node nodeToRemove = nodeBefore.getNext();

            nodeBefore.setNext(nodeToRemove.getNext());
            // remove node by point the node before to the node after
        }

        this.count--;
    }

    public void sort() {
        Node current = head;
        Node index = null;
        int temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                //Node index will point to node next to current
                index = current.getNext();

                while (index != null) {
                    // If current node's data is greater than index's node data, swap the data between them
                    if (current.getData() > index.getData()) {
                        temp = current.getData();
                        current.setData(index.getData());
                        index.setData(temp);
                    }
                    index = index.getNext();
                }
                current = current.getNext();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[count: " + this.count + "]=");

        Node current = getHead();

        while (current != null) {
            sb.append(current.getData() + ", ");
            current = current.getNext();
        }

        return sb.toString();
    }

    private Node getHead() {
        return this.head;
    }

    private Node getTail() {
        // start looking for a tail from the head
        Node current = getHead();

        // keep going until hit the last element (null)
        while ((current != null) && (current.getNext() != null)) {
            current = current.getNext();
        }

        return current;
    }

    private Node getNodeAt(int index) {
        // look for a node at the requested position
        Node currentNode = getHead();
        int currentPosition = 0;

        // index must be non-negative and less than count
        while ((index >= 0) && (index < this.getCount()) && (currentPosition != index) && (currentNode != null)) {
            // keep walking the list until index is reached
            currentNode = currentNode.getNext();
            currentPosition++;
        }

        return currentNode;
    }
}
