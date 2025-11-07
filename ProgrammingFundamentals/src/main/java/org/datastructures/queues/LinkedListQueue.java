package org.datastructures.queues;

public class LinkedListQueue<T> {

    //we create the node that represents the list
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> front;  // Points to the first element
    private Node<T> rear;   // Points to the last element
    private int size;       // Optional: track size

    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Add element to the end (enqueue)
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            //the last and the first element will be the unique element
            front = rear = newNode;
        } else {
            //new element will be colocated to the next place
            rear.next = newNode;
            //we change the reference to the last element as the new given node
            rear = newNode;
        }
        // we increase the size of element in the class for do not iterate to all linked list
        size++;
    }

    // Remove element from the front (dequeue)
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T value = front.data;
        front = front.next;
        //we sync the front and rear value if the front is empty
        if (front == null) rear = null; // if queue becomes empty
        size--;
        return value;
    }

    // Peek: get front element without removing
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Get size of queue
    public int size() {
        return size;
    }

    // Print all elements (for demo)
    public void printQueue() {
        Node<T> current = front;
        System.out.print("Front -> ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // --- Test ---
    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.printQueue();

        System.out.println("Dequeued: " + queue.dequeue());
        queue.printQueue();

        System.out.println("Peek: " + queue.peek());
        System.out.println("Size: " + queue.size());
    }
}
