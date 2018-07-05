/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadSamples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Ravi.Nistala
 */
public class test1 {

    public static void main(String[] args) throws Exception {
        //firstTest();
        //secondtest();
        thirdTest();

    }

    private static void thirdTest() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });

        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }

    }

    private static void secondtest() {
        // SECOND TEST
        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        //current thgread
        runnable.run();
        //new thread
        Thread thread = new Thread(runnable);
        thread.start();

        //THIRD TEST - ExcecuterService
    }

    private static void firstTest() {
        //FIRST TEST

        Runnable task = () -> {
            String threadName
                    = Thread.currentThread().getName();
            System.out.println("Hello "
                    + threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();
        System.out.println("Done!");
    }
}
