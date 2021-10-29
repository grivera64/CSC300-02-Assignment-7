//package assignment7.insertion;

/*
 *
 * Name: ArrayListSortGeneric.java
 * Purpose: Sorts ArrayLists
 * Author: grivera64
 *
 */

import java.util.ArrayList;

public class ArrayListSortGeneric {

    public static <T extends Comparable<T>> void insertionSort(ArrayList<T> list, int n) {

        /* n is the number of data stored in list */
        for (int i = 0; i < n; i++) {

            insert(list, i);

        }

    }

    public static <T extends Comparable<T>> void insert(ArrayList<T> list, int i) {

        /*
         * Place list.get(i) in its proper place
         * among sorted values
         * list.get(0), list.get(1), ... list.get(i - 1)
         */
        T temp = list.get(i);
        int j = i - 1;

        while (j >= 0 && temp.compareTo(list.get(j)) < 0) {     // determine where to place temp

            list.set(j + 1, list.get(j));                       // shift right
            j--;

        }

        list.set(j + 1, temp);

    }

}