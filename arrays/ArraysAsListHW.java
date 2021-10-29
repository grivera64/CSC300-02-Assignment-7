//package assignment7.arrays;

/*
 *
 * Name: ArraysAsListHW.java
 * Purpose: Shows the use of Arrays.asList() to convert
 *          a String array into a fixed list for easier
 *          iteration through it
 * Author: grivera64
 * Date: 31 October 2021
 *
 */

import java.util.Arrays;
import java.util.List;
import java.util.Iterator;

public class ArraysAsListHW {

    public static void main(String[] args) {

        /* Create a student names array and list (fixed in size) for iteration */
        String[] studentNamesArray = {"Ryan", "Alfred", "Beth"};
        List<String> studentNamesList = Arrays.asList(studentNamesArray);

        /* Print to the user */
        System.out.printf("Count of Student: %d\n", studentNamesList.size());

        System.out.println("List via Enhanced For");
        for (String s : studentNamesList)
        {

            System.out.printf("%s\n", s);

        }

        System.out.println("List via Iteration");
        Iterator<String> iter = studentNamesList.iterator();

        while (iter.hasNext()) {

            System.out.printf("%s\n", iter.next());

        }

    }

}
