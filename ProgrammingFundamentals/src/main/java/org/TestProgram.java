package org;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestProgram {


    static void main() {
        //input
        List<Integer> array = new ArrayList<>();
        array.add(10);
        array.add(15);
        array.add(8);
        array.add(49);
        array.add(25);
        array.add(98);
        array.add(32);

        array.stream()
                .filter(number -> number % 2 == 0)
                .toList()
                .forEach(evenNum -> System.out.println("Item:" + evenNum));

    }
}
