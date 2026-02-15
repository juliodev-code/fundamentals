package org.datastructures.binarytree;

public class BinarySearchToolkit {

    // 1. Standard Binary Search: Find target in a sorted array
    public static int standardSearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // 2. Rotated Search: Find target in an array that has been pivoted
    public static int rotatedSearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            // Identify which side is sorted
            if (nums[left] <= nums[mid]) {// Left side is sorted
                if (target >= nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            }
            else { // Right side is sorted
                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    // 3. Find Boundaries: Find first or last occurrence of a target
    // set findFirst to true for first occurrence, false for last
    public static int findBoundary(int[] nums, int target, boolean findFirst) {
        int left = 0, right = nums.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid; // Potential answer found
                if (findFirst) right = mid - 1; // Keep looking left
                else left = mid + 1;           // Keep looking right
            } else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return result;
    }

    static void main(String[] args) {
        // --- Test Standard Binary Search ---
        int[] sorted = {10, 20, 30, 40, 50};
        System.out.println("Standard (find 40): " + standardSearch(sorted, 40));

        // --- Test Rotated Search ---
        int[] rotated = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Rotated (find 0): " + rotatedSearch(rotated, 0));

        // --- Test First/Last Occurrence ---
        int[] duplicates = {1, 2, 2, 2, 2, 3, 4};
        int first = findBoundary(duplicates, 2, true);
        int last = findBoundary(duplicates, 2, false);
        System.out.println("First occurrence of 2: index " + first);
        System.out.println("Last occurrence of 2: index " + last);
    }
}


