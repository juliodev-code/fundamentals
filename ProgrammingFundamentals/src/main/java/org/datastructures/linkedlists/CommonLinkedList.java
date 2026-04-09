package org.datastructures.linkedlists;

import java.util.HashSet;
import java.util.Set;

public class CommonLinkedList {

    static class Node {
        public int value;
        public Node next;
        public Node prev;
    }

    public Node head;
    public Node tail;
    public int size;

    public void createLL(int nodeValue){
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        head = newNode;
        tail = newNode;
        size = 1;
    }

    public void insertNode(int nodeValue){
        if (head == null) {
            createLL(nodeValue);
            return;
        }


        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void traversal_LL(){
        Node tempNode = head;
        for(int i = 0; i < size; i++){
            System.out.print(tempNode.value);
            if(i != size - 1) System.out.print(" -> ");
            tempNode = tempNode.next;
        }

        System.out.println();
    }

    public void deleteDuplicates(){
        Set<Integer> uniqueValuesSet = new HashSet<>();
        Node current = head;
        Node prev = null;
        while(current != null){
            int currentVal = current.value;
            if(uniqueValuesSet.contains(currentVal)){
                prev.next = current.next;
                size--;
            }
            else{
                uniqueValuesSet.add(currentVal);
                prev = current;
            }
            current = current.next;
        }
    }

    public Node nthToLast(int n){
        Node p1 = head;
        Node p2 = head;
        for(int i = 0; i < n;i++){
            if(p2 == null)return null;
            p2 = p2.next;
        }
        while(p2 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    void partition(int x) {

        Node currentNode = head;
        tail = head;
        while(currentNode != null){
            Node next = currentNode.next;
            if(currentNode.value < x){
                currentNode.next = head;
                head = currentNode;
            }
            else {
                tail.next = currentNode;
                tail = currentNode;
            }
            currentNode = next;
        }

        tail.next = null;
    }

    CommonLinkedList sumLists(CommonLinkedList list1, CommonLinkedList list2){
        Node n1 = list1.head;
        Node n2 = list2.head;
        int carry = 0;

        CommonLinkedList resultLL = new CommonLinkedList();
        while(n1 != null || n2 != null){
            int result = carry;
            if(n1 != null){
                result += n1.value;
                n1 = n1.next;
            }

            if(n2 != null){
                result += n2.value;
                n2 = n2.next;
            }

            resultLL.insertNode(result%10);
            carry = result / 10;
        }

        return resultLL;

    }

    //intersection
    private static Node getKthNode(Node head, int k){
        Node current = head;
        while(k > 0 && current != null){
            current = current.next;
            k--;
        }

        return current;

    }

    static Node findIntersection(CommonLinkedList list1, CommonLinkedList list2){
        if(list1.head == null || list2.head == null) return null;
        //checking if the tail is intersecting
        if(list1.tail != list2.tail) return null;
        Node shorter = null;
        Node longer = null;

        if(list1.size > list2.size){
            longer = list1.head;
            shorter = list2.head;
        }
        else{
            longer = list2.head;
            shorter = list1.head;
        }

        longer = getKthNode(longer, Math.abs(list1.size - list2.size));
        while(shorter != longer){
            shorter = shorter.next;
            longer = longer.next;
        }

        return longer;
    }

    static void addSameNode(CommonLinkedList list1, CommonLinkedList list2, int nodeValue){
        Node newNode = new Node();
        newNode.value = nodeValue;

        list1.tail.next = newNode;
        list1.tail = newNode;

        list2.tail.next = newNode;
        list2.tail = newNode;
    }



    static void main() {
        CommonLinkedList linkedList = new CommonLinkedList();
        linkedList.createLL(1);
        linkedList.insertNode(9);
        linkedList.insertNode(5);
        linkedList.insertNode(10);
        linkedList.insertNode(2);
        //linkedList.deleteDuplicates();
        linkedList.traversal_LL();
        System.out.println(linkedList.nthToLast(1).value);
        linkedList.partition(4);
        linkedList.traversal_LL();

        CommonLinkedList linkedList1 = new CommonLinkedList();
        linkedList1.insertNode(3);
        linkedList1.insertNode(1);
        linkedList1.insertNode(5);
        linkedList1.insertNode(9);

        CommonLinkedList linkedList2 = new CommonLinkedList();
        linkedList2.insertNode(2);
        linkedList2.insertNode(4);
        linkedList2.insertNode(6);

        CommonLinkedList.addSameNode(linkedList1,linkedList2, 7);
        CommonLinkedList.addSameNode(linkedList1,linkedList2, 2);
        CommonLinkedList.addSameNode(linkedList1,linkedList2, 1);

        System.out.println(CommonLinkedList.findIntersection(linkedList1,linkedList2).value);
    }

}
