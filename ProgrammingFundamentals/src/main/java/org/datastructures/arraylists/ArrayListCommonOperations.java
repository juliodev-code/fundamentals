package org.datastructures.arraylists;

import java.util.List;
import java.util.ArrayList;

public class ArrayListCommonOperations<T> {

    public static void printNumbersFromOneToFive(){
        ArrayList<Integer> list = new ArrayList<>();
        for(int index = 0; index < 5; index++){
            list.add(index, index + 1);
            System.out.println(list.get(index));
        }
    }

    public static void contains(){
        ArrayList<Integer> list = new ArrayList<>();
        for(int index = 0; index < 5; index++){
            list.add(index, index + 1);
        }
        System.out.println("Is List containing 4?:" + list.contains(4));
        System.out.println("Is List containing 6?:" + list.contains(6));
    }

    public static void evenNumbers(int limit){
        ArrayList<Integer> list = new ArrayList<>();
        for(int index = 0; index < limit; index++){
            list.add(index, index + 1);
        }
    }

    static void main(String[] args){

        List<Integer> list = new ArrayList<>();
        list.add(10);
        int value = list.get(0);
        list.set(0, 99);
        list.remove(0);
        list.remove(Integer.valueOf(99));
        list.contains(10);
        list.size();

        list.add(21);
        System.out.println(list);

        printNumbersFromOneToFive();
        contains();
    }
}
