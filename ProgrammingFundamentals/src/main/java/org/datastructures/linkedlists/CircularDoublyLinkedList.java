package org.datastructures.linkedlists;

public class CircularDoublyLinkedList {
    class DoublyNode {
        int value;
        DoublyNode next;
        DoublyNode prev;
    }

    public DoublyNode head;
    public DoublyNode tail;
    public int size;

    //Create CDLL
    DoublyNode createCDLL(int nodeValue){
        //head = new DoublyNode();
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        head = newNode;
        tail = newNode;
        newNode.next = newNode;
        newNode.prev = newNode;
        size = 1;
        return head;
    }

    //Insertion method
    void insertNode(int nodeValue, int location){
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        if(head == null){
            createCDLL(nodeValue);
            return;
        }
        else if(location == 0){
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
        else if(location >= size){
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            tail = newNode;
        }
        else{
            DoublyNode tempNode = head;
            int index = 0;
            while(index < location - 1){
                tempNode = tempNode.next;
                index++;
            }
            newNode.prev = tempNode;
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            newNode.next.prev = newNode;
        }
        size++;
    }

    //traverse CDLL
    void transversalCDLL(){
        if(head != null){
            DoublyNode tempNode = head;
            for(int i = 0; i < size; i++){
                System.out.print(tempNode.value);
                if(i != size - 1) System.out.print(" -> ");
                tempNode = tempNode.next;
            }
        }
        else {
            System.out.print("CDLL does not exist");
        }
        System.out.println();
    }

    //Reverse transversal
    void reverseTransversal(){
        if(head != null){
            DoublyNode tempNode = tail;
            for(int i = 0; i < size; i++){
                System.out.print(tempNode.value);
                if(i != size - 1){
                    System.out.print(" <- ");
                }
                tempNode = tempNode.prev;
            }
        }
        else {
            System.out.print("CDLL does not exist");
        }
        System.out.println();
    }

    //search for a node
    boolean searchNode(int nodeValue){
        if(head != null){
            DoublyNode tempNode = head;
            for(int i = 0; i < size; i++){
                if(tempNode.value == nodeValue){
                    System.out.println("The value was found at location: " + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }

    public void deleteNode(int location){
        if(head == null){
            System.out.println("CDLL does not exist");
            return;
        }
        else if(location == 0){
            if(size == 1){
                head.prev = null;
                head.next = null;
                head = tail = null;
                size--;
                return;
            }
            else{
                head = head.next;
                head.prev = tail;
                tail.next = head;
                size--;
            }
        }
        else if(location >= size){
            if(size == 1){
                head.next = null;
                head.prev = null;
                head = tail = null;
                size--;
            }
            else{
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
                size--;
            }
        }
        else{
            DoublyNode tempNode = head;
            for(int i = 0; i < location - 1; i++) tempNode = tempNode.next;
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            size--;
        }
    }

    //delete entire CDLL
    public void deleteCDLL(){
        DoublyNode tempNode = head;
        for(int i = 0; i < size; i++){
            tempNode.prev = null;
            tempNode = tempNode.next;
        }
        head = tail = null;
        System.out.println("CDLL has been deleted!");
    }


    static void main() {
        CircularDoublyLinkedList call = new CircularDoublyLinkedList();
        call.createCDLL(1);
        call.insertNode(2, 0);
        call.insertNode(3, 1);
        call.insertNode(4, 2);
        call.transversalCDLL();
        call.reverseTransversal();
        call.searchNode(3);
        call.deleteNode(1);
        call.transversalCDLL();
        call.deleteCDLL();
        call.transversalCDLL();
    }
}
