package org.datastructures.stacks;

public class Stack {
    int[] arr;
    int topOfStack;

    public Stack(int size){
        this.arr = new int[size];
        this.topOfStack = -1;
        System.out.println("The stack was created with size of " + size);
    }

    public boolean isEmpty(){
        return topOfStack == -1;
    }

    public boolean isFull(){
        if(topOfStack == arr.length  - 1){
            System.out.println("The stack is full!");
            return true;
        }
        else return false;
    }

    public void push(int value){
        if(isFull()) System.out.println("The stack is full!!");
        else{
            arr[++topOfStack] = value;
            System.out.println("The element has been inserted");
        }
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("The stack is empty");
            return -1;
        }
        else{
            int topOftStack = arr[topOfStack];
            topOfStack--;
            return topOftStack;
        }
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("The stack is empty");
            return -1;
        }
        else return arr[topOfStack];
    }

    public void delete(){
        arr = null;
        System.out.println("The stack was successfully deleted.");
    }

    static void main() {
        Stack newStack = new Stack(4);
        newStack.push(1);
        newStack.push(2);
        newStack.push(3);
        newStack.push(4);

        int result = newStack.pop();
        System.out.println(result);
        int result1 = newStack.pop();
        System.out.println(result1);

        System.out.println("now the peek is: " + newStack.peek());

        newStack.delete();

    }
}
