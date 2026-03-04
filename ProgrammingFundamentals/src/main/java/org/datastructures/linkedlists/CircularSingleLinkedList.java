package org.datastructures.linkedlists;

public class CircularSingleLinkedList {

    public class Node {
        public int value;
        public Node next;
    }

    public Node head;
    public Node tail;
    public int size;

    public Node createCircularSingleLinkedList(int nodeValue){
        head = new Node();
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next =  newNode;
        head = newNode;
        tail = newNode;
        size = 1;
        return head;
    }

    public void insertCircularSingleLinkedList(int nodeValue, int location){
        Node newNode = new Node();
        newNode.value = nodeValue;
        if(head == null){
            createCircularSingleLinkedList(nodeValue);
            return;
        }
        else if(location == 0){
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        else if(location >= size){
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        else {
            Node tempNode = head;
            int index = 0;
            while(index < location - 1){
                tempNode = tempNode.next;
            }
            newNode.next = tempNode.next;
            tempNode.next = newNode;
        }
        size++;
    }

    //traversal method
    public void traversalCircularSingleLinkedList(){
        if(head != null){
            Node tempNode = head;
            for(int i = 0; i < size; i++){
                System.out.print(tempNode.value);
                if(i != size - 1) System.out.print("->");
                tempNode = tempNode.next;
            }

            System.out.print("\n");
        }
        else{
            System.out.println("CSLL does not exist!");
        }
    }

    //Search method
    public boolean searchNode(int nodeValue){
        if(head != null){
            Node tempNode = head;
            for(int i = 0; i < size; i++){
                if(tempNode.value == nodeValue){
                    System.out.println("Value found at location:" + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found!");
        return false;
    }

    //Delete method
    public void deleteNode(int location){
        if(head == null){
            System.out.println("CLL does not exist!");
            return;
        }
        else if(location == 0){
            head = head.next;
            tail = head;
            size--;
            if(size == 0){
                tail = null;
                head.next = null;
                head = null;
            }
        }
        else if(location >= size){
            Node tempNode = head;
            //we iterate to the last element
            for(int i = 0; i < size - 1; i++){
                tempNode = tempNode.next;
            }
            if(tempNode == head){
                head.next = null;
                tail = head = null;
                size--;
                return;
            }
            tempNode.next = head;
            tail = tempNode;
            size--;
        }
        else{
            Node tempNode = head;
            for(int i = 0; i < location - 1; i++){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }

    }

    //delete by value
    public boolean deleteByValue(int value){
        if (this.size == 0) {
            return false;
        }

        if (this.head == this.tail && this.head.value == value) {
            this.head = null;
            this.tail = null;
            this.size = 0;
            return true;
        }

        Node current = this.head;
        Node prev = null;

        do {
            if (current.value == value) {
                if (current == this.head) {
                    this.head = this.head.next;
                    this.tail.next = this.head;
                } else if (current == this.tail) {
                    prev.next = this.head;
                    this.tail = prev;
                } else {
                    prev.next = current.next;
                }

                this.size--;
                return true;
            }

            prev = current;
            current = current.next;
        } while (current != this.head);

        return false;
    }

    public void deleteWholeCircularLinkedList(){
        if(head == null){
            System.out.println("The linked list does not exist!");
        }
        else{
            head = null;
            tail.next = null;
            tail = null;
            System.out.println("The linked list has been deleted!");
        }
    }

    static void main() {
        CircularSingleLinkedList circularSingleLinkedList = new CircularSingleLinkedList();
        circularSingleLinkedList.createCircularSingleLinkedList(5);
        circularSingleLinkedList.insertCircularSingleLinkedList(4, 0);
        circularSingleLinkedList.insertCircularSingleLinkedList(6, 1);
        circularSingleLinkedList.insertCircularSingleLinkedList(7, 8);
        circularSingleLinkedList.traversalCircularSingleLinkedList();
        //circularSingleLinkedList.searchNode(7);
        circularSingleLinkedList.deleteNode(7);
        circularSingleLinkedList.deleteByValue(6);
        circularSingleLinkedList.traversalCircularSingleLinkedList();
        circularSingleLinkedList.deleteWholeCircularLinkedList();
        circularSingleLinkedList.traversalCircularSingleLinkedList();
    }
}
