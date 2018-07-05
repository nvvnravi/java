/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructuresSamples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.function.Consumer;

/**
 *
 * @author Ravi.Nistala
 */
public class SortStack {

    public static void main(String[] args) throws Exception {

        SortStack ss = new SortStack();        
        ss.sort();
        
       
    }

    private void sort() {
        Stack<Integer> s1 = new Stack<Integer>();
        s1.push(23);
        s1.push(46);
        s1.push(19);
        s1.push(5);
        System.out.println("  before sort ");
        s1.forEach(new Consumer<Integer>() {
            public void accept(Integer number) {
                System.out.println(" number : " + number);

            }
        });
        s1.sort(new numberComparator());
        // Arrays.sort(s1, new numberComparator());
        System.out.println("  after sort ");
        s1.forEach(new Consumer<Integer>() {
            public void accept(Integer number) {
                System.out.println(" number : " + number);

            }
        });
        
        System.out.println("  ##################  ");

        Stack<Integer> s2 = sortStack(s1);

        s2.forEach(new Consumer<Integer>() {
            public void accept(Integer number) {
                System.out.println(" number : " + number);

            }
        });

    }

    private class numberComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            Integer i1 = null, i2 = null;
            if (o1 instanceof Integer) {
                i1 = (Integer) o1;
            }
            if (o2 instanceof Integer) {
                i2 = (Integer) o2;
            }

            return i1.intValue() - i2.intValue();

        }

    }

    private static Stack<Integer> sortStack(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<Integer>();
         
        while (!s1.empty()) {
            Integer i1=s1.pop();            
            while(!s2.empty() &&  s2.peek().intValue() > i1.intValue()){
                s1.push(s2.pop());
            }
            s2.push(i1);

        }
return s2;
    }

}
