package org.datastructures.queues;

public class ArrayQueue<T> {
    private T[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queue = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Add element to end
    public void enqueue(T data) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        rear++;
        queue[rear] = data;
        size++;
    }

    // Remove element from front
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T value = queue[front];
        queue[front] = null; // optional: help GC
        front++;
        size--;
        return value;
    }

    // Peek first element
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public void printQueue() {
        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> q = new ArrayQueue<>(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.printQueue(); // 10 20 30

        q.dequeue();
        q.printQueue(); // 20 30

        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60); // OK, but queue is now full
        q.printQueue(); // 20 30 40 50 60
    }
}
