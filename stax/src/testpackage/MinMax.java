/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;

import java.util.Scanner;

/**
 *
 * @author Ravi.Nistala
 */
public class MinMax {
    public static void main(String[] args)
	{
            Scanner keyboard=new Scanner(System.in);
            int input=0;
            int min=0,max=0;            
            
            System.out.println("Please enter a non-zero integer to calculate, or 0 to exit");            
            
            input=keyboard.nextInt();
            min=input;
            max=input;
            
            while(input!=0){
                
                input=keyboard.nextInt();
                if(input != 0 && input > max)max=input;
                
                if(input != 0 && input < min)min=input;
            }
            
            System.out.println(" max : "+ max);
            System.out.println(" min : "+ min);
            
           
            
        }
    
    
}
