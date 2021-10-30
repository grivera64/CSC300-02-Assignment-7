//package assignment7.insertion;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class LinkedListSortGenericTester {

    public static void main(String[] args) {

        /* Local Variables */
        long timeStart, timeEnd, totalTime;
        int size;
        Random randy = new Random();
        Scanner keyboard = new Scanner(System.in);
        LinkedList<Integer> ll1;
        LinkedList<String> ll2;
        StringBuilder substr;
        LinkedListSortGeneric linkedListSortGeneric = new LinkedListSortGeneric();

        /* Create an Integer List of a specified capacity and fill it with random numbers */
        System.out.printf("Enter the size of the %s LinkedList: ", "Integer");
        size = keyboard.nextInt();
        ll1 = new LinkedList<>();

        for (int i = 0; i < size; i++) {

            ll1.add(randy.nextInt(2000));

        }

        System.out.println();

        timeStart = System.currentTimeMillis();
        linkedListSortGeneric.insertionSort(ll1, size);
        timeEnd = System.currentTimeMillis();

        totalTime = timeEnd - timeStart;
        System.out.printf("The total time for the %s LinkedList sort is %d milliseconds\n", "Integer", totalTime);
        System.out.print("Sorted: ");

        for (Integer i : ll1) {

            System.out.printf("%s ", i);

        }

        System.out.print("\n\n");

        /* Create a String List of a specified capacity and fill it with random numbers */
        System.out.print("Enter the size of the String ArrayList: ");
        size = keyboard.nextInt();
        ll2 = new LinkedList<>();

        substr = new StringBuilder(3);
        for (int i = 0; i < size; i++) {

            substr.setLength(0);

            for (int j = 0; j < 3; j++) {

                substr.append((char) (randy.nextInt(26) + 65));

            }

            ll2.add(substr.toString());

        }

        System.out.println();

        timeStart = System.currentTimeMillis();
        linkedListSortGeneric.insertionSort(ll2, size);
        timeEnd = System.currentTimeMillis();

        totalTime = timeEnd - timeStart;
        System.out.printf("The total time for the %s ArrayList sort is %d milliseconds\n", "String", totalTime);
        System.out.print("Sorted: ");

        for (String i : ll2) {

            System.out.printf("%s ", i);

        }

        System.out.println();

    }

}
