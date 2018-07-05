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
public class shapemanager {
    
    private shape s3=new defaultShape();
    
    public shape getShape(String shapeName){
        
        if("square".equals(shapeName)) s3=new square();
        if("triangle".equals(shapeName)) s3=new traingle();      
        
        
        return s3;
    }
    
}
