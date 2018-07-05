/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternSamples;

/**
 *
 * @author Ravi.Nistala
 */
public class factorytest {
    
    public static void main(String[] args){
        shapemanager sm=new shapemanager();
        System.out.println(sm.getShape("square").draw());
    }
    
}
