package org.algorithms.stringmanipulation;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class StringManipulation {
    private String two_pointer_reverseString(String stringForReverse){
        char[] stringChars = stringForReverse.toCharArray();
        int leftToRightIndex = 0, rightToLeftIndex = stringChars.length - 1;
        while(leftToRightIndex < rightToLeftIndex){
            char temp = stringChars[leftToRightIndex];
            stringChars[leftToRightIndex++] = stringChars[rightToLeftIndex];
            stringChars[rightToLeftIndex--] = temp;
        }
        return new String(stringChars);
    }

    private boolean two_pointer_isPalindrome(String stringForValidate){
        int left = 0, right = stringForValidate.length() - 1;
        while(left < right){
          if(stringForValidate.charAt(left++) != stringForValidate.charAt(right--)) return false;
        }
        return true;
    }

    private boolean frequency_counting_isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;

        int[] count = new int[26];
        for (char c : a.toCharArray()) count[c - 'a']++;
        for (char c : b.toCharArray()) {
            if (--count[c - 'a'] < 0) return false;
        }
        return true;
    }

    private char frequency_counting_firstUnique(String s) {
        int[] count = new int[256];

        for (char c : s.toCharArray()) count[c]++;
        for (char c : s.toCharArray()) {
            if (count[c] == 1) return c;
        }
        return '_';
    }

    private int frequency_counting_firstNonRepeatingCharacter(String s){
        int[] freq = new int[256];
        for (char c : s.toCharArray()) freq[c]++;
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)] == 1) return i;
        }
        return -1;
    }

    private int slidingWindow_longestSubstringWithoutRepeatingCharacters(String s){
        int left = 0, max = 0;
        Set<Character> set = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    private String stringBuilding_compress(String s){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 1; i <= s.length(); i++){
            if(i == s.length() || s.charAt(i) != s.charAt(i - 1)){
                sb.append(s.charAt(i - 1)).append(count);
                count = 1;
            }
            else count++;
        }
        return sb.toString();
    }

    private boolean parsingValidation_validParenthesis(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(c);
            }
            else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }


    static void main() {
        StringManipulation reverseString = new StringManipulation();
        System.out.println(reverseString.two_pointer_reverseString("hola"));
        System.out.println(reverseString.two_pointer_isPalindrome("amar"));
        System.out.println(reverseString.frequency_counting_isAnagram("amar","rama"));
        System.out.println(reverseString.frequency_counting_firstUnique("amar"));
        System.out.println(reverseString.frequency_counting_firstNonRepeatingCharacter("amar"));
        System.out.println(reverseString.slidingWindow_longestSubstringWithoutRepeatingCharacters("aba"));
        System.out.println(reverseString.stringBuilding_compress("aba"));
    }
}
