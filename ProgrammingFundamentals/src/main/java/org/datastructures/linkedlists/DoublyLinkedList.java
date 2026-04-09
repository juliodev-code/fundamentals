package org.datastructures.linkedlists;

public class DoublyLinkedList {

    class DoublyNode {
        int value;
        DoublyNode next;
        DoublyNode prev;
    }

    DoublyNode head;
    DoublyNode tail;
    int size;

    public DoublyNode createDLL(int nodeValue){
        head = new DoublyNode();

        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        newNode.next = null;
        newNode.prev = null;

        head = newNode;
        tail = newNode;

        size = 1;
        return head;
    }

    //insertion method
    public void insertDLL(int nodeValue, int location){
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        if(head == null){
            createDLL(nodeValue);
            return;
        }
        else if(location == 0){
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
        }
        else if(location >= size){
            newNode.next = null;
            tail.next = newNode;
            newNode.prev = tail;
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

    //Traverse DLL
    public void transverseDLL(){
        if(head != null){
            DoublyNode tempNode = head;
            for(int i = 0; i < size; i++){
                System.out.print(tempNode.value);
                if(i != size - 1) System.out.print(" -> ");
                tempNode = tempNode.next;
            }
        }
        else{
            System.out.println("The DLL does not exist!");
        }
        System.out.println("\n");
    }

    //Reverse transverse
    public void reverseTransverseDLL(){
        if(head != null){
            DoublyNode tempNode = tail;
            for(int i = 0; i < size; i++){
                System.out.print(tempNode.value);
                if(i < size  - 1){
                    System.out.print(" <- ");
                }
                tempNode = tempNode.prev;
            }
        }
        else{
            System.out.println("The DLL does not exist!");
        }
        System.out.println("\n");
    }

    //search node
    public boolean searchNode(int nodeValue){
        if(head != null){
            DoublyNode tempNode = head;
            for(int i = 0; i < size; i++){
                if(tempNode.value == nodeValue){
                    System.out.print("The node was found at location " + i);
                    System.out.println("\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }else{
            System.out.print("Node not found");
        }
        System.out.println("\n");
        return false;
    }

    //Deletion method
    public void deleteNodeDLL(int location){
        if(head == null){
            System.out.println("The DLL does not exist");
            return;
        }
        else if(location == 0){
            if(size == 1){
                head = null;
                tail = null;
                size--;
                return;
            }
            else{
                head = head.next;
                head.prev = null;
                size--;
            }
        }
        else if(location >= size -1){
            DoublyNode tempNode = tail.prev;
            if(size == 1){
                head = null;
                tail = null;
                size--;
                return;
            }
            else {
                tempNode.next = null;
                tail = tempNode;
                size--;
            }

        }
        else{
            DoublyNode tempNode = head;
            for(int i = 0; i < location -1; i++){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            size--;
        }

    }

    //Delete entire DLL
    public void deleteDLL(){
        DoublyNode tempNode = head;
        for(int i = 0; i < size; i++){
            tempNode.prev = null;
            tempNode = tempNode.next;
        }
        head = null;
        tail = null;
        System.out.println("DLL was deleted");
    }

    static void main() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.createDLL(1);
        doublyLinkedList.insertDLL(2,0);
        doublyLinkedList.insertDLL(3,1);
        doublyLinkedList.insertDLL(4,7);
        doublyLinkedList.transverseDLL();
        doublyLinkedList.reverseTransverseDLL();
        doublyLinkedList.searchNode(4);
        doublyLinkedList.deleteNodeDLL(3);
        doublyLinkedList.transverseDLL();
        doublyLinkedList.deleteDLL();
        doublyLinkedList.transverseDLL();
    }
}
