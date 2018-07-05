/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructuresSamples;


import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;


/**
 *
 * @author Ravi.Nistala
 */
public class LinkedListTest {

    public static void main(String[] args) throws Exception {

        LinkedList ll = new LinkedList();
        ll.add(3);
        ll.add(2);
        ll.add(1);
        ll.add(4);
        ll.add(5);
        ll.add(5);        
        ll.add(6);
        ll.add(6);
        
        
        ll.get(1);
        ll.get(1);
        

        Iterator iter2 = ll.iterator();
        while (iter2.hasNext()) {
            System.out.println(iter2.next());
        }
        
        
        
        // create a hash set
      HashSet hs = new HashSet();
      
      // add elements to the hash set
      hs.add("B");
      hs.add("A");
      hs.add("D");
      hs.add("E");
      hs.add("C");
      hs.add("F");
      hs.add("A");
       hs.add(1);

      System.out.println(hs);
            System.out.println(hs.size());

      
    }

}
