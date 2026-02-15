package org.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsPattern {

    public List<List<Integer>>findSubsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        //Start the recursive process
        backtrack(result,new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer>tempList,int[] nums, int start){
        // 1. Add the current combination to the result
        // We create a NEW list because tempList keeps changing
        result.add(new ArrayList<>(tempList));

        // 2. Iterate through the remaining elements
        for (int i = start; i < nums.length; i++) {
            // 3. Include the element
            tempList.add(nums[i]);
            // 4. Move to the next element (i + 1)
            backtrack(result, tempList, nums, i + 1);
            // 5. Backtrack: Remove the element to try the next branch
            tempList.removeLast();
        }
    }

    static void main(String[] args) {
        SubsetsPattern solver = new SubsetsPattern();
        int[] nums = {1, 2, 3};
        List<List<Integer>> allSubsets = solver.findSubsets(nums);

        System.out.println("All possible subsets:");
        for (List<Integer> subset : allSubsets) {
            System.out.println(subset);
        }
    }
}
