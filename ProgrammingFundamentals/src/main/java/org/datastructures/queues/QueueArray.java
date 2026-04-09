package org.datastructures.queues;

public class QueueArray {
    int[]arr;
    int topOfQueue;
    int beginningOfTheQueue;

    public QueueArray(int size){
        this.arr = new int[size];
        this.topOfQueue = -1;
        this.beginningOfTheQueue = -1;
        System.out.println("Queue created with a size of " + size);
    }

    public boolean isFull(){
        if(topOfQueue == arr.length - 1) return true;
        else return false;
    }
    public boolean isEmpty(){
        if(beginningOfTheQueue == -1 || beginningOfTheQueue == arr.length){
            return true;
        }
        else return false;
    }

    public void enqueue(int value){
        if(isFull()){
            System.out.println("The queue is full and you can not add more items");
        }
        else if(isEmpty()){
            beginningOfTheQueue = 0;
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Successfully inserted " + value + " in the queue");
        }
        else{
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Successfully inserted " + value + " in the queue");
        }
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("There is not element in the queue!! ");
            return -1;
        }
        else{
            int result = arr[beginningOfTheQueue];
            beginningOfTheQueue++;
            if(beginningOfTheQueue > topOfQueue){
                beginningOfTheQueue = topOfQueue = -1;
            }
            return result;
        }
    }

    public int peek(){
        if(!isEmpty()) return arr[beginningOfTheQueue];
        else {
            System.out.println("The queue is empty!");
            return -1;
        }
    }

    public void deleteQueue(){
        arr = null;
        System.out.println("Queue is successfully deleted");
    }

    static void main() {
        QueueArray queue = new QueueArray(3);
        System.out.println("Is queue full:" + queue.isFull());
        System.out.println("Is queue empty:" + queue.isEmpty());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        int result = queue.peek();
        System.out.println(result);

        result = queue.peek();
        System.out.println(result);

        queue.deleteQueue();

        System.out.println("Is queue full:" + queue.isFull());
        System.out.println("Is queue empty:" + queue.isEmpty());

    }

}
