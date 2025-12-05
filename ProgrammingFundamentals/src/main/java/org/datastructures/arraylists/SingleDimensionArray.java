package org.datastructures.arraylists;

public class SingleDimensionArray {

    int[] arr = null;

    public SingleDimensionArray(int sizeOfArray){
        this.arr = new int[sizeOfArray];
        for(int i = 0; i < this.arr.length; i++)
            this.arr[i] = Integer.MIN_VALUE;

    }

    public void insert(int location, int valueToInsert){//O(1)
        try{
            if(this.arr[location] == Integer.MIN_VALUE)
                this.arr[location] = valueToInsert;
            else
                System.out.println("The location is already occupied");

        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("The location does not exist in array");
        }
    }

    public void traversal(){
        try{
            for (int j : this.arr)
                System.out.print(j + " ");

        }catch (Exception ex){
            System.out.println("Array does not exist");
        }

    }

    public void searchInArray(int valueToSearch){
        for(int i = 0; i < this.arr.length; i++){
            if(this.arr[i] == valueToSearch){
                System.out.println("Value found at index " + i);
                return;
            }
        }
        System.out.println("Value not found in array");
    }

    public void deleteValue(int valueToDeleteIndex){
        try {
            arr[valueToDeleteIndex] = Integer.MIN_VALUE;
            System.out.println("The value has been deleted successfully");
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("The index provided was not found in the index range of the array");
        }
    }

    static void main() {
        SingleDimensionArray array = new SingleDimensionArray(10);
        array.insert(0, 0);
        array.insert(1, 10);
        array.insert(2, 20);
        array.insert(1, 30);
        array.insert(12, 120);

        var firstElement = array.arr[0];
        System.out.println(firstElement);

        var thirdElement = array.arr[3];
        System.out.println(thirdElement);

        array.traversal();
        array.searchInArray(30);
        array.deleteValue(2);

    }
}
