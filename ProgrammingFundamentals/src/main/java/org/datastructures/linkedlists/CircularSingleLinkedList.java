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

    static void main() {
        CircularSingleLinkedList circularSingleLinkedList = new CircularSingleLinkedList();
        circularSingleLinkedList.createCircularSingleLinkedList(5);
        circularSingleLinkedList.insertCircularSingleLinkedList(3, 0);
        circularSingleLinkedList.insertCircularSingleLinkedList(3, 0);
        circularSingleLinkedList.insertCircularSingleLinkedList(3, 0);
        System.out.println(circularSingleLinkedList.head.value);

    }
}
