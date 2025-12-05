package org.datastructures.arraylists;

import java.util.Arrays;

public class TwoDimensionalArray {

    final int [][]arr;

    public TwoDimensionalArray(int numberOfRows, int numberOfColumns){
        this.arr = new int[numberOfRows][numberOfColumns];
        for(int row = 0; row < this.arr.length; row++){
            for(int col = 0; col < this.arr[0].length; col++){
                this.arr[row][col] = Integer.MIN_VALUE;
            }
        }
    }

    public void insertValueInTheArray(int row, int col, int value){
        try{
            if(arr[row][col] == Integer.MIN_VALUE){
                arr[row][col] = value;
                System.out.println("The value was successfully inserted");
            }
            else {
                System.out.println("The place is already occupied");
            }
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Invalid indexes provided to 2D array");
        }
    }

    public void accessCell(int row, int col){
        System.out.println("Accessing Row#" + col + ", col#" + col);
        try{
            System.out.println("Cell value is: " + this.arr[row][col]);
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Invalid indexes provided to 2D array");
        }
    }

    public void traverse2DArray(){
        for(int row = 0; row < this.arr.length; row++){
            for(int col = 0; col < this.arr[0].length; col++){
                System.out.print(arr[row][col] + ", ");
            }
            System.out.println();
        }
    }

    public void searchingValue(int valueToSearch){
        for(int row = 0; row < this.arr.length; row++){
            for(int col = 0; col < this.arr[0].length; col++){
                if(this.arr[row][col] == valueToSearch){
                    System.out.println("Value found in row#" + row + ", col#" + col);
                    return;
                }
            }
        }
        System.out.println("Value not found in array.");
    }

    public void deleteValueFromArray(int row, int col){
        try{
            this.arr[row][col] = Integer.MIN_VALUE;
            System.out.println("Element successfully deleted");
        }
        catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Invalid indexes provided to 2D array");
        }
    }

    static void main() {
        //Declare
        int [][] int2Array;
        //Instantiation
        int2Array = new int[2][2];
        //Initialization
        int2Array[0][0] = 1;//o(m*n)
        int2Array[0][1] = 2;
        int2Array[1][0] = 3;
        int2Array[1][1] = 4;
        //
        System.out.println(Arrays.deepToString(int2Array));

        String[][] str2Array = {{"a","b"},{"c","d"}};
        System.out.println(Arrays.deepToString(str2Array));

        TwoDimensionalArray twoDimensionalArray = new TwoDimensionalArray(3, 3);
        twoDimensionalArray.insertValueInTheArray(0,0, 10);

        System.out.println(Arrays.deepToString(twoDimensionalArray.arr));
        twoDimensionalArray.accessCell(0,0);
        twoDimensionalArray.traverse2DArray();
        twoDimensionalArray.searchingValue(10);
        twoDimensionalArray.deleteValueFromArray(0,0);
        twoDimensionalArray.searchingValue(10);

    }
}
