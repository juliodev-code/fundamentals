package org.concepts;

public class Recursion {
    static void main() {
        System.out.println("Factorial:" + factorial(5));
    }
    public static int factorial(int n){
        if(n < 1 )return -1;
        if(n == 1)return 1;
        return n * factorial(n - 1 );
    }
}
