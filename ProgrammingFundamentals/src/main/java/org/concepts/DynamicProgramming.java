package org.concepts;

import java.util.ArrayList;
import java.util.HashMap;

public class DynamicProgramming {
    static void main() {
        HashMap<Integer, Integer> memo = new HashMap<>();
        System.out.println("Fibonacci :" + fiboMemo(6, memo));
        System.out.println("Fibonacci :" + fiboTab(6));
    }

    //Top down approach
    public static int fiboMemo(int n, HashMap<Integer, Integer> memo){
        if(n == 1) return 0;
        if(n == 2) return 1;
        if(!memo.containsKey(n)) memo.put(n, (fiboMemo(n - 1, memo) + fiboMemo(n - 2, memo)));
        return memo.get(n);
    }

    //Bottom up approach
    public static int fiboTab(int n){
        ArrayList<Integer> tab = new ArrayList<>();
        tab.add(0);
        tab.add(1);
        Integer n1,n2;
        for(int i=2; i<=n-1; i++){
            n1 = tab.get(i - 1);
            n2 = tab.get(i - 2);
            tab.add(n1 + n2);
        }
        return tab.get(n - 1);
    }
}
