package org.datastructures.linkedlists;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class LinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // add the new node to the end to the list
    public void add(int data){
        Node newNode = new Node(data);

        if (head == null){
            this.head = newNode;
            return;
        }

        Node current = head;
        while(current.next != null){
            current = current.next;
        }

        current.next = newNode;

    }

    //delete a node according the value
    public void remove(int data){
        //we check if the value is in the head of the list
        if(head == null) return;
        if(head.data == data){
            head = head.next;
            return;
        }
        Node current = head;
        //we iterate until find the node in next value
        while(current.next != null && current.next.data != data){
            current = current.next;
        }
        // we proceed with deleting the value referencing to the next value
        if(current.next != null){
            current.next = current.next.next;
        }
    }

    //search a value
    public boolean contains(int data){
        Node current = head;
        while(current != null){
            if(current.data == data) return true;
            current = current.next;
        }
        return false;
    }

    //get size of list

    public int size(){
        int counter = 0;
        Node current = head;
        while(current != null){
            counter++;
            current = current.next;
        }

        return counter;
    }

    public void printList(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;

        }
        System.out.println("null");
    }

    public void reverse(){
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next; // save
            curr.next = prev;          // reverse
            prev = curr;               // move prev
            curr = next;               // move curr
        }
        head = prev;
    }

    static void main() {
        LinkedList lists = new LinkedList();
        lists.add(10);
        lists.add(20);
        lists.add(30);

        System.out.println("Initial list:");
        lists.printList();

        lists.remove(20);
        System.out.println("After delete node with data == 20 list:");
        lists.printList();

        System.out.println("Does it contain 20? " + lists.contains(20));
        System.out.println("Does it contain 30? " + lists.contains(30));

        System.out.println("List size: " + lists.size());

        lists.reverse();
        lists.printList();

    }
}
