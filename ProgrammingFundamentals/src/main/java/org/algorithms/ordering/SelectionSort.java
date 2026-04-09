package org.algorithms.ordering;

public class SelectionSort {

    /**
     * Selection Sort Algorithm
     * Time Complexity: O(n^2) - Always (Best, Average, Worst)
     * Space Complexity: O(1) - In-place
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;

    }

    public static void main(String[] args) {
        int[] data = {64, 25, 12, 22, 11};

        System.out.println("Original Array:");
        printArray(data);

        selectionSort(data);

        System.out.println("\nSorted Array:");
        printArray(data);
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
