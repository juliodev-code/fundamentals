package org.datastructures.stacks;

public class StackMinimum {

    public class Node {
        public int value;
        public Node next;

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    Node top;
    Node min;

    public StackMinimum(){
        top = null;
        min = null;
    }

    public int min(){
        return min.value;
    }

    public void push(int value){
        if(min == null){
            min = new Node(value, min);
        }
        else if(min.value < value){
            min = new Node(min.value, min);
        }
        else{
            min = new Node(value, min);
        }

        top = new Node(value, top);
    }

    public int pop(){
        min = min.next;
        int result = top.value;
        top = top.next;
        return result;
    }

    static void main() {
        StackMinimum stackMinimum = new StackMinimum();
        stackMinimum.push(3);
        stackMinimum.push(2);
        stackMinimum.push(-1);
        System.out.println("The minimum is:" + stackMinimum.min());
        stackMinimum.pop();
        System.out.println("The minimum is:" + stackMinimum.min());
    }
}
