package org.datastructures.vector;

import java.util.Vector;

public class VectorExample {
    static void main() {
        Vector<Integer> numbers = new Vector<>();

        //add elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        // Access elements
        System.out.println(numbers.get(0)); // Output: 10

        // Remove element
        numbers.remove(1); // Removes 20

        // Iterate through Vector
        for (int num : numbers) {
            System.out.println(num);
        }

        // Size and capacity
        System.out.println("Size: " + numbers.size());
        System.out.println("Capacity: " + numbers.capacity());
    }
}
