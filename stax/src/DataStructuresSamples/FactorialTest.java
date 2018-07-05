/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructuresSamples;

/**
 *
 * @author Ravi.Nistala
 */
public class FactorialTest {
    
     public static void main(String[] args) throws Exception {
      
         FactorialTest ft=new FactorialTest();
         System.out.println(ft.calculateFactorial(5));
    
     System.out.println(6/2);
     System.out.println(6/2d);   
    
     }
    
     
     private  long calculateFactorial(int number){
         if(number == 1) return number;
         return number * calculateFactorial(number-1);
     }
}
