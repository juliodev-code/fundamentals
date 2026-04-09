package org.concepts.recursion;

public class Recursion {
    static void main() {

        System.out.println("Factorial:" + factorial(5));
        recursiveMethod(5);
        System.out.println("Fibonacci:" + fibonacci(3));

        int[] A = new int[]{11,4,12,7};
        System.out.println(findMaxValueInArray(A, A.length));
    }
    public static int factorial(int n){
        //if the number is negative, we return -1 because negative numbers are not valid
        if(n < 1 )return -1;
        //factorial zero and one its factorial is zero
        if(n == 1)return 1;
        return n * factorial(n - 1 );
    }

    public static void recursiveMethod(int n){
        if(n < 1) System.out.println("n is less than one");
        else {
            Recursion.recursiveMethod(n -1);
            System.out.println(n);
        }
    }

    public static int fibonacci(int n){
        if(n == -1) return -1;
        if(n == 0 || n == 1) return n;
        return fibonacci(n - 1 ) + fibonacci( n - 2);
    }

    public static int findMaxValueInArray(int [] simpleArray, int n){
        if(n == 1) return simpleArray[0];
        return Math.max(simpleArray[n - 1],findMaxValueInArray(simpleArray,n - 1));
    }
}
