package org.datastructures.stacks;

import org.datastructures.linkedlists.SingleLinkedList;

public class LinkedListStack {

    SingleLinkedList linkedList;

    public LinkedListStack(){
        this.linkedList = new SingleLinkedList();
    }

    //Push
    public void push(int value){
        linkedList.insertSinglyLinkedList(value, 0);
        System.out.println("Inserted " + value + " in the stack");
    }

    public boolean isEmpty(){
        return linkedList.head == null;
    }

    public int pop(){
        int result = -1;
        if(isEmpty()) System.out.println("The stack is empty");
        else{
            result = linkedList.head.value;
            linkedList.deletionOfNode(0);
        }

        return result;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("The stack is empty");
            return -1;
        }
        else return linkedList.head.value;
    }

    public void deleteStack(){
        linkedList.head = null;
        System.out.println("The stack was deleted");

    }

    static void main() {
        LinkedListStack stack = new LinkedListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.deleteStack();

    }


}
