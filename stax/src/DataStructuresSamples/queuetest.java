/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructuresSamples;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;

/**
 *
 * @author Ravi.Nistala
 */
public class queuetest {

    public static void main(String a[]) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(3);
        LinkedList<Integer> linkedList1 = new LinkedList<Integer>();
        linkedList1.add(8);
        linkedList1.add(4);
        linkedList1.add(2);
        //linkedList1.add(6);
        Queue<Integer> finalResult = new LinkedList<Integer>();
        fun1(linkedList, linkedList1);
        System.out.println("===============================");

        linkedList = new LinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(3);
        linkedList1 = new LinkedList<Integer>();
        linkedList1.add(8);
        linkedList1.add(4);
        linkedList1.add(2);
        
        LinkedList<Integer> rl = new LinkedList<Integer>();        
        System.out.println(reverseLinkedList(rl, linkedList1, linkedList1.size() - 1));
        System.out.println("=========================");
        //sorting();
        System.out.println("=========================");
        
        System.out.println("1^7 :"+(1 ^ 7));
        System.out.println("7^14 :"+(7 ^ 14));
        System.out.println("14^8 :"+(14 ^ 8));
        System.out.println("8^2 :"+(8 ^ 2));
        System.out.println("2^1 :"+(2 ^ 1));
        System.out.println("=========================");
        
        System.out.println("6^9 :"+(6 ^ 9));
        System.out.println("9^6 :"+(9 ^ 6));
        System.out.println("6^10 :"+(6 ^ 10));
        System.out.println("10^3 :"+(10 ^ 3));
        System.out.println("3^6 :"+(3 ^ 6));
        System.out.println("=========================");
        boolean stop = false;
        int carry = 0;
        while (!stop) {
            int int1 = 0, int2 = 0;
            if (!linkedList.isEmpty()) {
                int1 = linkedList.remove();
            }
            if (!linkedList1.isEmpty()) {
                int2 = linkedList1.remove();
            }

            int result = int1 + int2 + carry;

            if (result > 9) {
                result = result - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            finalResult.add(result);
            if (linkedList.isEmpty() && linkedList1.isEmpty()) {
                if (carry == 1) {
                    finalResult.add(1);
                }
                stop = true;
            }
        }
        //print the result
        finalResult.stream().forEach(System.out::println);
    }

    private static void fun1(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();
        while (!l1.isEmpty()) {
            st1.push(l1.remove());
        }
        while (!l2.isEmpty()) {
            st2.push(l2.remove());
        }
        LinkedList<Integer> result = new LinkedList<Integer>();
        int s1 = l1.size();
        int s2 = l2.size();

        int diff = 0;
        int carry = 0;
        if (s1 > s2) {
            diff = s1 - s2;
            for (int i = 0; i > s2; i++) {
                int res = l1.get(i) + l2.get(i) + carry;
                if (res > 9) {
                    res = res - 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                result.add(res);
            }

            for (int i = 0; i > diff; i++) {
                int res = l1.get(i) + carry;
                if (res > 9) {
                    res = res - 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                result.add(res);
            }

        } else {

            if (s2 > s1) {
                diff = s2 - s1;

                for (int i = 0; i > s2; i++) {
                    int res = l1.get(i) + l2.get(i) + carry;
                    if (res > 9) {
                        res = res - 10;
                        carry = 1;
                    } else {
                        carry = 0;
                    }
                    result.add(res);
                }

                for (int i = 0; i > diff; i++) {
                    int res = l2.get(i) + carry;
                    if (res > 9) {
                        res = res - 10;
                        carry = 1;
                    } else {
                        carry = 0;
                    }
                    result.add(res);
                }
            } else {
                //equal
                System.out.println("equal");
                while (!st1.isEmpty()) {
                    //for (int i = s2-1; i ==0; i--) {
                    //System.out.println("l1.get(i):"+l1.get(i));
                    int res = st1.pop() + st2.pop() + carry;
                    //System.out.println("res:"+res);
                    if (res > 9) {
                        res = res - 10;
                        carry = 1;
                    } else {
                        carry = 0;
                    }
                    result.add(res);
                }
            }
        }
        if (carry > 0) {
            result.add(carry);
        }

        //print the result
        result.stream().forEach(System.out::println);

        System.out.println(factorial(5));
        System.out.println(power(2, 5));

    }

    public static long factorial(long n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int power(int x, int n) {
        if (n == 1) {
            return x;
        } else {
            return x * power(x, n - 1);
        }
    }

    private static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> rl, LinkedList<Integer> l1, int size) {

        rl.add(l1.get(size));
        if (size == 0) {
            return rl;
        }

        return reverseLinkedList(rl, l1, size - 1);

    }
    
    private static void sorting(){
        TreeSet<Integer> t=new TreeSet<>();
        t.add(60);
        t.add(30);
        t.add(10);
        t.add(-5);
        t.add(1000);
        t.add(50);
        t.add(60);
        t.add(90);
        t.add(1000);
        t.add(0);
        t.add(100);
        t.add(-1000);
        System.out.println("Ceiling value for 13: "+t.ceiling(13));  
        System.out.println("Ceiling value for 60: "+t.ceiling(60));  
        t.stream().forEach( System.out::println);
    }
}
