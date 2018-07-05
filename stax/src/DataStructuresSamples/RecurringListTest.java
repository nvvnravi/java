/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructuresSamples;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Ravi.Nistala
 */
public class RecurringListTest {
      public static void main(String[] args)  {          
          RecurringListTest rlt=new RecurringListTest();
          List<Integer> l1=Arrays.asList(23,45,67);
          String test="test";
          rlt.printList(l1,test);
      }
      
      public void printList(List<Integer> l1,String t1){
          int i=0;
          System.out.println(" Integer Value : "+l1.get(i).intValue()+"     String Value :   "+t1); 
          printList(l1,t1);
      }
}
