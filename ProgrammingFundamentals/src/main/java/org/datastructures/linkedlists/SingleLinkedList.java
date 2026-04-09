package org.datastructures.linkedlists;

public class SingleLinkedList {

    public class Node {
        public int value;
        public Node next;
    }

    public Node head;
    public Node tail;
    public int size;

    public Node createSinglyLinkedList(int nodeValue){
        head = new Node();

        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;

        head = newNode;
        tail = newNode;

        size = 1;
        return head;
    }

    public void insertSinglyLinkedList(int value, int location){
        Node newNodeToInsert = new Node();
        newNodeToInsert.value = value;

        if(head == null){
           //new linkedlist
            createSinglyLinkedList(value);
            return;
        }
        else if(location == 0) {
            //new node at the beginning
            newNodeToInsert.next = head;
            head = newNodeToInsert;
        }
        else if(location >= size){
            //insertion at the end if the linkedlist
            newNodeToInsert.next = null;
            tail.next = newNodeToInsert;
            tail = newNodeToInsert;
        }
        else {
            //inserting element at the middle of the list
            Node tempNode = head;
            int index = 0;
            while(index < (location - 1)){
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = newNodeToInsert;
            newNodeToInsert.next = nextNode;
        }
        size++;
    }

    public void traverseSinglyLinkedList(){
        if(head == null) System.out.println("SLL is not created");
        else{
            Node tempNode = head;
            for(int i = 0; i < size; i++){
                System.out.print(tempNode.value);
                if(i != (size - 1)) System.out.print(" -> ");
                tempNode = tempNode.next;
            }
        }
        System.out.println("\n");
    }

    public boolean searchNode(int nodeValue){
        if(head != null){
            Node tempNode = head;
            for(int i = 0; i < size; i++){
                if(tempNode.value == nodeValue){
                    System.out.println("Value located at location " + i + "\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found! ");
        return false;
    }

    public void deletionOfNode(int location){
        if(head == null){
            System.out.println("The SLL does not exist");
            return;
        }
        else if(location == 0){
            head = head.next;
            size--;
            if(size == 0) tail = null;
        }
        else if(location >= size){
            Node tempNode = head;
            for(int i = 0; i < size - 1; i++){
                tempNode = tempNode.next;
            }
            if(tempNode == head){
                tail = head = null;
                size--;
                return;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
        }
        else {
            Node tempNode = head;
            for(int i = 0; i < location -1; i++){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    public void deleteEntireLinkedList(){
        head = null;
        tail = null;
        size = 0;
        System.out.println("SLL deleted successfully");
    }

    static void main() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.createSinglyLinkedList(5);
        System.out.println(singleLinkedList.head.value);

        singleLinkedList.insertSinglyLinkedList(6, 1);
        System.out.println(singleLinkedList.head.next.value);

        singleLinkedList.insertSinglyLinkedList(7, 3);
        System.out.println(singleLinkedList.head.next.next.value);



        singleLinkedList.insertSinglyLinkedList(6, 0);
        /*singleLinkedList.insertSinglyLinkedList(7, 1);
        singleLinkedList.insertSinglyLinkedList(8, 2);
        singleLinkedList.insertSinglyLinkedList(9, 3);*/
        singleLinkedList.traverseSinglyLinkedList();
        singleLinkedList.searchNode(10);
        singleLinkedList.deletionOfNode(2);
        singleLinkedList.traverseSinglyLinkedList();
        singleLinkedList.deleteEntireLinkedList();
        singleLinkedList.traverseSinglyLinkedList();
    }
}
