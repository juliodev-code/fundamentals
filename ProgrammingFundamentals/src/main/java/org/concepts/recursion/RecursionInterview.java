package org.concepts.recursion;

public class RecursionInterview {
    public static int sumOfDigits(int n){
        //we return zero for stop the recursion and avoid negative numbers
        if(n == 0 || n < 0) return 0;
        return n % 10 + sumOfDigits(n/10);
    }

    public static int power(int base, int exp){
        if(exp < 0) return -1;
        if(exp == 0 )return 1;
        return base * power(base, exp - 1);
    }

    public static int gcd(int a, int b){
        if(a < 0 || b < 0) return -1;
        if(b == 0)return a;
        return gcd(b, a%b);
    }

    public static int decimalToBinary(int n){
        if(n == 0) return 0;
        return n % 2 + 10 * decimalToBinary( n / 2);
    }

    static void main() {
        System.out.println("sumOfDigits(7):" + sumOfDigits(117));
        System.out.println("Power(2, 3):" + power(2, 3));
        System.out.println("GCD(48,18):" + gcd(48, 18));
        System.out.println("decimalToBinary(2):" + decimalToBinary(2));
    }
}
