package com.company;

import java.time.ZonedDateTime;

public class Main {

    /*// Runnable class
    public static class Run implements Runnable {
        @Override
        public void run() {
            System.out.println("Inner class!");
        }
    }

    // Main
    public static void main(String[] args) {

        // First thread
        Run r1 = new Run();
        Thread t1 = new Thread(r1);
        t1.start();

        // Second thread
        Runnable r2 = new Runnable () {
            @Override
            public void run() {System.out.println(
                    "Anonymous class! Param: " + (0 == args.length ? "No param." : args[0]));
            }
        };
        Thread t2 = new Thread(r2);
        t2.start();

        // Third thread
        Runnable r3 = () -> System.out.println("Lambda!");
        Thread t3 = new Thread(r3);
        t3.start();

        // Fourth thread
        new Thread(() -> System.out.println("OneLine!")).start();
    }*/
}
