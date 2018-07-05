/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructuresSamples;


import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Ravi.Nistala
 */
public class ArrayRotate {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        int[] result = leftShift(a, k);

        for (int a_i = 0; a_i < n; a_i++) {
            System.out.println(result[a_i]);
        }
    }

    private static int[] leftShift(int[] a, int numberOfShifts) {

        int size = a.length;
        int[] result = new int[size];
        
        
        //covert int[] to linked list
        LinkedList<Integer> ll = new LinkedList<Integer>();
        for (int i = 0; i < size; i++) {
            ll.add(a[i]);
        }
        //shift the values based on number of shifts
        for (int i = 0; i < numberOfShifts; i++) {
            System.out.println("  before shift    ");
            ll.forEach((temp) -> {
                System.out.println(temp);
            });
            int lastNumber = ll.getLast();
            System.out.println("  lastNumber    " + lastNumber);
            int firstNumber = ll.getFirst();
            System.out.println("  firstNumber    " + firstNumber);
            ll.remove(0);
            //ll.remove(size-1);
            ll.addLast(firstNumber);
            //ll.set(size - 1, firstNumber);
            System.out.println("  after shifting   ");
            ll.forEach((temp) -> {
                System.out.println(temp);
            });
        }
 System.out.println("  after shifting  - size   "+ll.size());
 Integer[] intArray=ll.toArray(new Integer[size]);
        //convert linked back to int[] and return it
        for (int i = 0; i < size; i++) {
          //  System.out.println(ll.get(i));
            result[i] = intArray[i];
        }

        return result;
    }
}
