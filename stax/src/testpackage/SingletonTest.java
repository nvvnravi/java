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
public enum SingletonTest {
    instance;

    private String ts = "";

    public String getValue() {
        return ts;
    }

    public void setValue(String s1) {
        ts = s1;
    }
}
