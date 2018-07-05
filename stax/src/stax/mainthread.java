/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stax;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ravi.Nistala
 */
public class mainthread {

    private final List<String> taskQueue;

    public mainthread(List<String> sharedQueue) {
        this.taskQueue = sharedQueue;
    }

    public static void main(String[] args) throws Exception {
        List<String> taskQueueMain = new ArrayList<String>();
        mainthread mt = new mainthread(taskQueueMain);
        mt.spawnThreads();
    }

    public void spawnThreads() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            Thread th = new Thread(new testthread(taskQueue), "Thread-" + i);
            th.setDaemon(false);
            th.start();
            //th.join();    
        }

        synchronized (taskQueue) {
            while (taskQueue.size() != 10) {
                System.out.println("Waiting for jobs to finish");
                taskQueue.wait();
            }
            
        }
        
         System.out.println("DONE!!!!!!!");

    }

}
