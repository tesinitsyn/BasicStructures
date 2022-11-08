package org.example;

import java.util.ArrayList;
import java.util.List;

public class ClassForTests {
    public static void main(String[] args) {
        ArrayList<Integer> newArrayList = new ArrayList<>();
        newArrayList.add(1);
        newArrayList.add(2);
        newArrayList.add(3);
        newArrayList.add(4);
        newArrayList.add(5);
        newArrayList.add(6);
        newArrayList.add(5);
        //newArrayList.toArray();
        Integer[] arr = new Integer[2];

        arr[0] = 5;
        arr[1] = 6;


        newArrayList.retainAll(List.of(arr));

        /*arr = newArrayList.toArray(new Integer[4]);

        System.out.print(newArrayList.containsAll(List.of(arr)));

        for (int i = 0; i < 4; i++) {
            System.out.print(arr[i]);
        }*/

        System.out.print(newArrayList);



    }
}
