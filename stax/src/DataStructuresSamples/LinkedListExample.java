/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructuresSamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Ravi.Nistala
 */
public class LinkedListExample {
   public static void main(String args[]) {
ArrayList<String> al1= new ArrayList<String>();
          al1.add("hi");
          al1.add("How are you");
          al1.add("Good Morning");
          al1.add("bye");
          al1.add("Good night");

          ArrayList<String> al2= new ArrayList<String>();
          al2.add("Howdy");
          al2.add("Good Evening");
          al2.add("bye");
          al2.add("Good night");

          //Storing the comparison output in ArrayList<String>
          ArrayList<String> al3= new ArrayList<String>();
          for (String temp : al1)
              al3.add(al2.contains(temp) ? "Yes" : "No");
          System.out.println(al3);

          //Storing the comparison output in ArrayList<Integer>
          ArrayList<Integer> al4= new ArrayList<Integer>();
          for (String temp2 : al1)
               al4.add(al2.contains(temp2) ? 1 : 0);
          System.out.println(al4);
          
          
          List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
            //get list of unique squares
            List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
            
            System.out.println(squaresList);
     } 
}
