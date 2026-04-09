package org.datastructures.queues;

import java.util.Stack;

public class QueueTwoStacks {
    Stack<Integer> stackNewest, stackOldest;

    public QueueTwoStacks(){
        stackOldest = new Stack<Integer>();
        stackNewest = new Stack<Integer>();
    }

    public int size(){
        return stackNewest.size() + stackOldest.size();
    }

    public void enqueue(int value){
        stackNewest.push(value);
    }

    private void shiftStacks(){
        if(stackOldest.isEmpty()){
            while(!stackNewest.isEmpty()){
                int poppedOutElem = stackNewest.pop();
                stackOldest.push(poppedOutElem);
            }
        }
    }

    public int dequeue(){
        shiftStacks();
        return stackOldest.pop();
    }

    public int peek(){
        shiftStacks();
        return stackOldest.peek();
    }

    static void main() {
        QueueTwoStacks queueTwoStacks = new QueueTwoStacks();
        queueTwoStacks.enqueue(1);
        queueTwoStacks.enqueue(2);
        queueTwoStacks.enqueue(3);
        System.out.println("Element peeked:" + queueTwoStacks.peek());
        queueTwoStacks.enqueue(4);
        System.out.println("Element attended:" + queueTwoStacks.dequeue());
    }
}
