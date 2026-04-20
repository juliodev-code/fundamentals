package org.datastructures.tree;

public class BinaryTreeArray {
    String[] arr;
    int lastIndexUsed;

    public BinaryTreeArray(int size){
        this.arr = new String[size + 1];
        this.lastIndexUsed = 0;
        System.out.println("Binary tree of size " + size + " has been created.");
    }

    boolean isFull(){
        return this.arr.length - 1 == lastIndexUsed;
    }

    void insert(String value){
        if(!isFull()){
            this.arr[lastIndexUsed + 1] = value;
            lastIndexUsed++;
            System.out.println("The value " + value + " has been inserted");
        }
        else System.out.println("The BT is full");
    }

    void preOrder(int index){
        if(index > lastIndexUsed) return;
        System.out.print(this.arr[index] + " ");
        preOrder(index * 2);//left
        preOrder(index * 2 + 1);//right

    }

    void inOrder(int index){
        if(index > lastIndexUsed) return;
        inOrder(index * 2);
        System.out.print(this.arr[index] + " ");
        inOrder(index * 2 + 1);
    }

    void postOrder(int index){
        if(index > lastIndexUsed) return;
        postOrder(index * 2);
        postOrder(index * 2 + 1);
        System.out.print(this.arr[index] + " ");
    }

    void levelOrder(){
        for(int i = 1; i <= lastIndexUsed; i++){
            System.out.print(this.arr[i] + " ");
        }
    }

    public int search(String value){
        for(int i = 1; i <= lastIndexUsed; i++){
            if(this.arr[i].equals(value)){
                System.out.println(value + " exist in index " + i);
                return i;
            }
        }
        System.out.println("The value does not exist in BT");
        return -1;
    }

    public void delete(String value){
        int location = search(value);
        if(location == -1) return;
        else{
            this.arr[location] = this.arr[lastIndexUsed];
            lastIndexUsed--;
            System.out.println("The node was successfully deleted");
        }
    }

    public void deleteBT(){
        try{
            this.arr = null;
            System.out.println("The BT has been deleted");
        }catch (Exception ex){
            System.out.println("There was an error deleting the tree");
        }
    }

    static void main() {
        BinaryTreeArray binaryTree = new BinaryTreeArray(9);
        binaryTree.insert("N1");
        binaryTree.insert("N2");
        binaryTree.insert("N3");
        binaryTree.insert("N4");
        binaryTree.insert("N5");
        binaryTree.insert("N6");
        binaryTree.insert("N7");
        binaryTree.insert("N8");
        binaryTree.insert("N9");

        binaryTree.preOrder(1);
        System.out.println();
        binaryTree.inOrder(1);
        System.out.println();
        binaryTree.postOrder(1);
        System.out.println();
        binaryTree.levelOrder();
        System.out.println();
        binaryTree.search("N7");
        binaryTree.search("N10");

        binaryTree.delete("N3");
        binaryTree.levelOrder();
        System.out.println();
        binaryTree.deleteBT();
    }
}
