package org.algorithms.ordering;

public class InsertionSort {

    /**
     * Insertion Sort Algorithm
     * Time Complexity: O(n^2) - Worst Case
     * Time Complexity: O(n) - Best Case (Already sorted)
     * Space Complexity: O(1) - In-place
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        // Start from the second element (index 1)
        for (int i = 1; i < n; ++i) {
            int key = arr[i]; // The element we are currently "inserting"
            int j = i - 1;
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            // Place the key in its correct sorted position
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] data = {12, 11, 13, 5, 6};

        System.out.println("Original Array:");
        printArray(data);

        insertionSort(data);

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
