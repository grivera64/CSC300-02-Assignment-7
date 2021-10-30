//package assignment7.insertion;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ArrayListSortGenericTester {

    public static void main(String[] args) {

        /* Local Variables */
        long timeStart, timeEnd, totalTime;
        int size;
        Random randy = new Random();
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Integer> al1;
        ArrayList<String> al2;
        StringBuilder substr;
        ArrayListSortGeneric arrayListSortGeneric = new ArrayListSortGeneric();

        /* Create an Integer List of a specified capacity and fill it with random numbers */
        System.out.printf("Enter the size of the %s ArrayList: ", "Integer");
        size = keyboard.nextInt();
        al1 = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {

            al1.add(randy.nextInt(2000));

        }

        System.out.println();

        timeStart = System.currentTimeMillis();
        arrayListSortGeneric.insertionSort(al1, size);
        timeEnd = System.currentTimeMillis();

        totalTime = timeEnd - timeStart;
        System.out.printf("The total time for the %s ArrayList sort is %d milliseconds\n", "Integer", totalTime);
        System.out.print("Sorted: ");

        for (Integer i : al1) {

            System.out.printf("%s ", i);

        }

        System.out.print("\n\n");

        /* Create a String List of a specified capacity and fill it with random numbers */
        System.out.printf("Enter the size of the %s ArrayList: ", "String");
        size = keyboard.nextInt();
        al2 = new ArrayList<>(size);


        substr = new StringBuilder();
        for (int i = 0; i < size; i++) {

            substr.setLength(0);

            for (int j = 0; j < 3; j++) {

                substr.append((char) (randy.nextInt(26) + 65));

            }

            al2.add(substr.toString());

        }

        System.out.println();

        timeStart = System.currentTimeMillis();
        arrayListSortGeneric.insertionSort(al2, size);
        timeEnd = System.currentTimeMillis();

        totalTime = timeEnd - timeStart;
        System.out.printf("The total time for the %s ArrayList sort is %d milliseconds\n", "String", totalTime);
        System.out.print("Sorted: ");

        for (String i : al2) {

            System.out.printf("%s ", i);

        }

        System.out.println();

    }

}
