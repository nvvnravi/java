/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructuresSamples;

import java.util.*;

/**
 *
 * @author Ravi.Nistala
 */
public class StringTest {

    public static void main(String[] args) throws Exception {
        //stringtests();
        //hashSetTest();
        //reverseString();
        //anagramTest();
        //uniqueCharctersTest();
        String s="abcdef";
        System.out.println(s.substring(1, 3));
        

        
    }

    private static void uniqueCharctersTest(){
        System.out.println("Enter the String to test for unique characters....");
        Scanner readInput=new Scanner(System.in);
        String stringInput=readInput.next();
        System.out.println("String Entered is ...."+stringInput);
        int initialLength=stringInput.length();
        char[] chars=stringInput.toCharArray();
        HashSet<Character> hashSet=new HashSet<Character>();
        for(int i=0;i<chars.length;i++){
            hashSet.add(Character.valueOf(chars[i]));            
        }
        
        int finalLength=hashSet.size();
        
        if(initialLength==finalLength)System.out.println("String Entered has unique characters");
        else System.out.println("String Entered does not have unique characters");
        
        
    }
    private static void reverseString(){
        System.out.println("Enter the String to reverse....");
        Scanner readInput=new Scanner(System.in);
        String stringInput=readInput.next();
        System.out.println("String Entered is ...."+stringInput);
        StringBuffer sb=new StringBuffer(stringInput);
        System.out.println("String Entered is ...."+sb.reverse());
    }
    
     private static void anagramTest(){
        System.out.println("Enter the First String....");
        Scanner readInput1=new Scanner(System.in);
        String stringInput1=readInput1.next();
        System.out.println("Enter the Secong String....");
        Scanner readInput2=new Scanner(System.in);        
        String stringInput2=readInput2.next();
        System.out.println("String Entered is ...."+stringInput1);
        System.out.println("String Entered is ...."+stringInput2);
        char[] c1=stringInput1.toCharArray();
        char[] c2=stringInput2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        System.out.println("stringInput1 after sorting ....");
        for(int i=0;i<c1.length;i++){
            System.out.println(c1[i]);            
        }
        System.out.println("stringInput2 after sorting ....");
        for(int i=0;i<c1.length;i++){
            System.out.println(c1[i]);            
        }
        
        
        
        
        
    }
    
    private static void stringtests() {
        String s1 = "test";
        System.out.println("   s1  " + s1.charAt(2));
        System.out.println("   s2  " + s1.codePointAt(3));
        System.out.println("   s3  " + s1.compareTo("test"));
        System.out.println("   s4  " + s1.compareTo("test1"));
        System.out.println("   s5  " + s1.concat("-test2"));
        System.out.println("   s6  " + s1.contains("es"));
        System.out.println("   s7  " + s1.contentEquals("st"));
        System.out.println("   s8  " + s1.contentEquals(new StringBuffer().append("e").append("s")));
        System.out.println("   s9  " + s1.equals("test"));
        System.out.println("   s10  " + s1.equals("test1"));
        System.out.println("   s11  " + s1.equalsIgnoreCase("TEST"));
        System.out.println("   s12  " + s1.equalsIgnoreCase("TEST"));
        System.out.println("   s13  " + s1.valueOf(true));
        System.out.println("   s14  " + s1.valueOf(23));
        System.out.println("   s15  " + s1.valueOf(23.37));
        System.out.println("   s15  " + s1.indexOf("st"));
        System.out.println("   s15  " + s1.indexOf('s'));
        System.out.println("   s15  " + s1.indexOf("st", 1));

    }

    private static void hashSetTest() {
        Set<String> h = new HashSet<String>() {
            {
                add("a");
                add("t");
                add("u");
                add("v");
                add("w");
                add("x");
                add("y");
                add("z");
                add("t");
            }
        };
        System.out.println("   h1  " + h);
        System.out.println("   h2  " + h.contains("u"));
        System.out.println("   h3  " + h.contains("b"));
        h.remove("y");
        System.out.println("   h4  " + h);

        h.removeAll(new ArrayList<String>(Arrays.asList(new String[]{"t", "u"})));
        System.out.println("   h5  " + h);
    }
}
