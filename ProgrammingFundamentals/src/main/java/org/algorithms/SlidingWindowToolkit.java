package org.algorithms;

public class SlidingWindowToolkit {

    /**
     * FIXED WINDOW: Find the maximum sum of any contiguous subarray of size K.
     * Strategy: Add the next element, then subtract the element falling out of the window.
     */

    public static int findMaxSumFixed(int[] nums, int k) {
        if (nums == null || k > nums.length) return 0;
        int maxSum = 0;
        int windowSum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right]; // Add the next element
            // Once we hit the window size 'k', start sliding
            if (right >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[left]; // Remove element exiting the window
                left++; // Slide the window start forward
            }
        }
        return maxSum;
    }

    /**
     * DYNAMIC WINDOW: Find the length of the smallest subarray with a sum >= target.
     * Strategy: Expand until condition is met, then shrink as much as possible to find the "minimum".
     */

    public static int findMinSubarrayDynamic(int[] nums, int target) {
        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right]; // Expand the window
            // Shrink the window as long as the condition is still met
            while (windowSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                windowSum -= nums[left]; // Remove element from the back
                left++; // Shrink
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args) {
        // --- Test Fixed Window ---
        int[] fixedData = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int maxFixed = findMaxSumFixed(fixedData, k);
        System.out.println("Fixed Window (Size " + k + "):");
        System.out.println("Max sum of subarray: " + maxFixed); // Expected: 9 ([5, 1, 3])

        System.out.println("---------------------------");

        // --- Test Dynamic Window ---
        int[] dynamicData = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int minDynamic = findMinSubarrayDynamic(dynamicData, target);
        System.out.println("Dynamic Window (Target Sum >= " + target + "):");
        System.out.println("Smallest subarray length: " + minDynamic); // Expected: 2 ([4, 3])
    }
}
