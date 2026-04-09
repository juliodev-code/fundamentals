package org.algorithms.ordering;

public class BubbleSort {

    /**
     * Bubble Sort Algorithm
     * Space Complexity: O(1) - In-place
     * Time Complexity: O(n^2) - Average/Worst Case
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Outer loop: Number of passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // Inner loop: Adjacent comparisons
            // n - i - 1 because the last 'i' elements are already sorted
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap adjacent elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // Optimization: If no two elements were swapped, array is sorted
            if (!swapped) break;
        }
    }


    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original Array:");
        printArray(data);

        bubbleSort(data);

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
