/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructuresSamples;

import java.util.Stack;

/**
 *
 * @author Ravi.Nistala
 */
public class MyWordReverse {

    public String reverseWord(String word) {

        StringBuilder sb = new StringBuilder();
        int size = word.length();
        Stack stack = new Stack();
        for (int i = 0; i < size; i++) {
            stack.push(word.charAt(i));
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String a[]) {
        MyWordReverse mwr = new MyWordReverse();
        System.out.println("Java2Novice == " + mwr.reverseWord("Java2Novice"));
        System.out.println("Java == " + mwr.reverseWord("Java"));
        System.out.println("program == " + mwr.reverseWord("program"));
        System.out.println("we3456 == " + mwr.reverseWord("we3456"));
    }
}
