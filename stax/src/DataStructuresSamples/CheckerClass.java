/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructuresSamples;

import java.util.Arrays;

/**
 *
 * @author Ravi.Nistala
 */
public class CheckerClass {

    public static void main(String[] args) throws Exception {
        Player[] players = new Player[5];

        players[0] = new Player("ab", 23);
        players[1] = new Player("bc", 56);
        players[2] = new Player("bd", 56);
        players[3] = new Player("cd", 34);
        players[4] = new Player("de", 56);

        System.out.println(" Before Sorting   ");
        for (int i = 0; i < 5; i++) {
            System.out.println("Name : " + players[i].getName() + "       Score  :  " + players[i].getScore());
        }

        System.out.println(" After Score Sorting   ");
        Arrays.sort(players, new ScoreComparator());
        for (int i = 0; i < 5; i++) {
            System.out.println("Name : " + players[i].getName() + "       Score  :  " + players[i].getScore());
        }

        System.out.println(" After name Sorting   ");
        Arrays.sort(players, new NameComparator());
        for (int i = 0; i < 5; i++) {
            System.out.println("Name : " + players[i].getName() + "       Score  :  " + players[i].getScore());
        }
    }

}
