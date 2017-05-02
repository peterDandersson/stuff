package com.company;

import org.w3c.dom.css.Counter;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        int numberOfJobs = 9;
        int threads = Runtime.getRuntime().availableProcessors() - 1;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        CountDownLatch latch = new CountDownLatch(numberOfJobs);

        for (int i = 1; !(i > numberOfJobs); i++) {
            executorService.submit(new Job(i, latch));
        }

        try {
            latch.await();
            executorService.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Job implements Runnable {
    int id;
    CountDownLatch latch;

    public Job(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; !(i > id); i++){
            sb.append(id);
            System.out.println(sb);
        }
        latch.countDown();
    }
}
