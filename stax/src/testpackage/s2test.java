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
public class s2test {
    
    public void chages1Value(){
        SingletonTest.instance.setValue("string from s2test");
    }
    
    public String displays1Value(){
        return SingletonTest.instance.getValue();
    }
}
