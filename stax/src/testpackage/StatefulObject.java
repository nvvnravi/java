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
public class StatefulObject {
     private State state;

    public StatefulObject() {
        state = State.INITIAL;
    }

    public void performRequest(String aParameter) {
        state = state.doSomething(aParameter);
    }

    public static void main(String[] args) {
        StatefulObject theObject = new StatefulObject();
        theObject.performRequest("Hello");
        theObject.performRequest("Hello");
        theObject.performRequest("Hello");
       
    }
}
