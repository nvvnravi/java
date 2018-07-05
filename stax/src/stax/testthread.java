/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stax;

import java.util.List;

/**
 *
 * @author Ravi.Nistala
 */
public class testthread implements Runnable {

    private final List<String> taskQueue;

    public testthread(List<String> sharedQueue) {
        this.taskQueue = sharedQueue;
    }

    public void run() {

        try {
            printNumbers();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }

    public void printNumbers() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);

        }
        //write to queue
        synchronized (taskQueue) {
            
            taskQueue.add("done");
            System.out.println("added to queue");
            if(taskQueue.size() ==10)taskQueue.notify();
        }

    }

}
