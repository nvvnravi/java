/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructuresSamples;

import java.util.Scanner;

/**
 *
 * @author Ravi.Nistala
 */
public class balanced_delimiter {
    public static void main(String[] args){               
        
        System.out.println("Enter the input String");
        Scanner getInput=new Scanner(System.in);        
        String inputString=getInput.next();
        System.out.println(containBalancedDelimeter(inputString));        
    }
    
    private static boolean  containBalancedDelimeter(String inputString){
        
        boolean result=false;
        
     final char openBracket='(' ;
     final char closedBracket=')' ;
     final char openCurlyBracket='{' ;
     final char closedCurlyBracket='}' ;
     final char openSquareBracket='[' ;
     final char closedSquareBracket=']' ;
        
 char[] charArray=inputString.toCharArray();
 for(int i=0;i<inputString.length();i++){
 //check for matching OpenBracket
     if(charArray[i]== openBracket){
          System.out.println("openBracket    : "+i);
     int index=inputString.indexOf(closedBracket);
     if((index > i) && ((index-i) %2) !=0 ) result= true;else{ return false;}
    }
     
      if(charArray[i]== closedBracket){
          System.out.println("closedBracket    : "+i);
     int index=inputString.indexOf(openBracket);
     if((index != -1) && (index <  i) ){ result= true;}else{ return false;}
    }
     
     //check for matching OpenCurlyBracket
     if(charArray[i]== openCurlyBracket){
         System.out.println("openCurlyBracket    : "+i);
     int index=inputString.indexOf(closedCurlyBracket);
     if((index > i) && ((index-i) %2) !=0 ) result= true;else { return false;}
    }
     if(charArray[i]== closedCurlyBracket){
          System.out.println("closedCurlyBracket    : "+i);
     int index=inputString.indexOf(openCurlyBracket);
     if((index != -1) && (index <  i) ){ result= true;}else{ return false;}
    }
     
     //check for matching OpenSquareBracket
     if(charArray[i]== openSquareBracket){
         System.out.println("openSquareBracket    : "+i);
     int index=inputString.indexOf(closedSquareBracket);
     if((index > i) && ((index-i) %2) !=0 ) result= true;else { return false;}
    }
     if(charArray[i]== closedSquareBracket){
          System.out.println("closedSquareBracket    : "+i);
     int index=inputString.indexOf(openSquareBracket);
     if((index != -1) && (index <  i) ){ result= true;}else{ return false;}
    }
 }
 
        return result;
    }
}
