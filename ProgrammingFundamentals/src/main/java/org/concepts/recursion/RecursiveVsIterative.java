package org.concepts.recursion;

public class RecursiveVsIterative {

    static int powerOfTwo(int n){
        if (n == 0) return 1;
        else return 2 * powerOfTwo(n - 1);
    }

    static int powerOfTwoIterative(int n){
        var i = 0;
        var power = 1;
        while(i < n){
            power = power * 2;
            i = i + 1;
        }
        return power;
    }

    static void main() {
        System.out.println("2 and 3 = " + powerOfTwo(3));
        System.out.println("2 and 3 = " + powerOfTwoIterative(3));
    }
}
