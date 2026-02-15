package org.algorithms.twosum;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class TwoSum {
    static void main() {
        int[] numbers = new int[]{3, 2, 4};
        int target = 6;

        TwoSum twoSumClass = new TwoSum();
        System.out.println(Arrays.toString(twoSumClass.hashAlgorithm(numbers,target)));

        numbers = new int[]{2, 3, 4};
        System.out.println(Arrays.toString(twoSumClass.twoPointerAlgorithm(numbers,target)));
    }

    //use it when the elements are not ordered
    public int[] hashAlgorithm(int[] numbers, int target){
        Map<Integer,Integer> map = new HashMap<>();
        int complement = 0;
        for(int i = 0; i < numbers.length; i++){
            complement = target - numbers[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i };
            }
            map.put(numbers[i], i);
        }
        return new int[]{};
    }

    //use it when the elements are ordered
    public int[] twoPointerAlgorithm(int[] numbers, int target){
       int left = 0, right = numbers.length - 1, sum = 0;
       while(left < right){
           sum = numbers[left] + numbers[right];
           if(sum == target) return new int[]{left, right};
           if(sum < target)left++;else right--;
       }

        return new int[]{};
    }
}
