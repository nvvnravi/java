/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructuresSamples;


import java.util.Comparator;

/**
 *
 * @author Ravi.Nistala
 */
public class ScoreComparator implements Comparator {
    
    @Override
    public int compare(Object o1, Object o2) {
        Player p1=null;
        Player p2=null;
        
        if(o1 instanceof Player)
        p1=(Player)o1;
        if(o2 instanceof Player)
        p2=(Player)o2;
        
        
       // return p2.getScore()- p1.getScore();
        return p1.getScore()- p2.getScore();
    }
    
}
