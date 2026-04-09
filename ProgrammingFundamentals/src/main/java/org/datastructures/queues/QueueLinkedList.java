package org.datastructures.queues;

import org.datastructures.linkedlists.SingleLinkedList;

public class QueueLinkedList {

    SingleLinkedList list;

    public QueueLinkedList(){
        list = new SingleLinkedList();
        System.out.println("The queue was successfully created");
    }

    public boolean isEmpty(){
        return list.head == null;
    }

    public void enQueue(int value){
        this.list.insertSinglyLinkedList(value, list.size);
        System.out.println("Successfully inserted " + value + " in the queue");
    }

    public int dequeue(){
        int value = -1;
        if(isEmpty()) System.out.println("The queue is empty");
        else {
            value = list.head.value;
            list.deletionOfNode(0);
        }
        return value;
    }

    public int peek(){
        if(isEmpty()) {
            System.out.println("The queue is empty!");
            return -1;
        }
        else return list.head.value;
    }

    public void deleteQueue(){
        list.head = list.tail = null;
        System.out.println("Queue successfully deleted");
    }

    static void main() {
        QueueLinkedList queue = new QueueLinkedList();
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        System.out.println("Dequeue:" +queue.dequeue());
        System.out.println("Current value" + queue.peek());
        System.out.println("Is queue empty:" + queue.isEmpty());
        queue.deleteQueue();


    }
}
