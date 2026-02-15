package org.datastructures.arraylists;

public class LinearSearch {

    public void linearSearch(int[] intArray, int valueToSearch){
        for(int i = 0; i < intArray.length; i++){
            if(intArray[i] == valueToSearch){
                System.out.println("Values was found at index " + i);
                return;
            }
        }
        System.out.println("The value was not found");
    }

    static void main() {
        int[] intArray = {1,2,3,4,5,6};
        LinearSearch linearSearch = new LinearSearch();
        linearSearch.linearSearch(intArray, 5);
    }
}
