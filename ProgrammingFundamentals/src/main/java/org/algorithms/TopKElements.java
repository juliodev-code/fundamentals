package org.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKElements {

    public List<Integer> findKLargest(int[] nums, int k) {
        // 1. Create a Min-Heap (default behavior of PriorityQueue in Java)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 2. Iterate through the array
        for (int num : nums) {
            minHeap.add(num);
            // 3. If heap size > k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 4. The heap now contains the K largest elements
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        TopKElements solver = new TopKElements();
        int[] nums = {3, 10, 5, 20, 1, 15};
        int k = 3;

        System.out.println("The " + k + " largest elements are: " + solver.findKLargest(nums, k));
        // Output: [10, 15, 20]
    }
}
