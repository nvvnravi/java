/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;

/**
 *
 * @author Ravi.Nistala
 */
public class s1test {
    public static void main (String[] args){
       
        SingletonTest.instance.setValue("first");
        System.out.println(SingletonTest.instance.getValue());
        SingletonTest.instance.setValue("second");
        System.out.println(SingletonTest.instance.getValue());
        s2test s2=new s2test();
        s2.chages1Value();
        System.out.println(SingletonTest.instance.getValue());
        SingletonTest.instance.setValue("third");
       System.out.println(s2.displays1Value());
    }
}
