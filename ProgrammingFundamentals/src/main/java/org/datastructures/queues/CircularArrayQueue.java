package org.datastructures.queues;

public class CircularArrayQueue {
    int[] arr;
    int topOfQueue;
    int beginningOfQueue;
    int size;

    public CircularArrayQueue(int size){
        this.arr = new int[size];
        this.size = size;
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("Circular queue was created with size of " + size);
    }

    public boolean isEmpty(){
        return this.beginningOfQueue == -1 || this.topOfQueue == 1;
    }

    public boolean isFull(){
        if(topOfQueue + 1 == beginningOfQueue){
            return true;
        }
        else if(beginningOfQueue == 0 && topOfQueue + 1 == size){
            return true;
        }
        else{
            return false;
        }
    }

    public void enQueue(int value){
        if(isFull()){
            System.out.println("Circular Array is full!");
        }
        else if(isEmpty()){
            beginningOfQueue = 0;
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Successfully inserted " + value + " in the queue");
        }
        else{
            if(topOfQueue + 1 == size) topOfQueue = 0;
            else topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Successfully inserted " + value + " in the queue");
        }
    }

    public int deQueue(){
        if(isEmpty()){
            System.out.println("The Circular Array Queue is empty");
            return -1;
        }
        else {
            int result = arr[beginningOfQueue];
            arr[beginningOfQueue] = 0;
            if(beginningOfQueue == topOfQueue){
                beginningOfQueue = topOfQueue = -1;
            }
            else if(beginningOfQueue + 1 == size){
                beginningOfQueue = 0;
            }
            else{
                beginningOfQueue++;
            }

            return  result;
        }
    }

    public int peek(){
        if(isEmpty()) {
            System.out.println("The Circular Array is empty");
            return -1;
        }
        else{
            return arr[beginningOfQueue];
        }
    }

    public void deleteQueue(){
        arr = null;
        System.out.println("Circular Array queue was deleted successfully");
    }

    static void main() {
        CircularArrayQueue circularArrayQueue = new CircularArrayQueue(3);
        System.out.println(circularArrayQueue.isEmpty());
        circularArrayQueue.enQueue(10);
        circularArrayQueue.enQueue(20);
        circularArrayQueue.enQueue(30);
        System.out.println(circularArrayQueue.peek());
        System.out.println(circularArrayQueue.peek());
        circularArrayQueue.deleteQueue();
    }

}
