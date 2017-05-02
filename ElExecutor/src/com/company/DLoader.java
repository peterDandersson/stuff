package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Created by Peter on 2017-01-26.
 */
public class DLoader {

    public DLoader(Map<String,String> filesToLoad){

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(filesToLoad.size());
        BlockingQueue<String> q = new ArrayBlockingQueue(filesToLoad.size());


        executorService.submit(new DownLoader(q, latch, filesToLoad));
        executorService.submit(new NamePrinter(q, latch));

        try {
        latch.await();
        System.out.println("All done!");
        executorService.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class DownLoader implements Runnable {
    BlockingQueue<String> q;
    CountDownLatch countDownLatch;
    Map<String,String> urls;

    public DownLoader(BlockingQueue<String> q, CountDownLatch countDownLatch, Map<String,String> urls) {
        this.q = q;
        this.countDownLatch = countDownLatch;
        this.urls = urls;
    }

    @Override
    public void run() {
        try {
            Iterator it = urls.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry<String,String> pair = (Map.Entry) it.next();

                final URL url = new URL(pair.getValue());
                final URLConnection conn = url.openConnection();
                final BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                final String pageText = reader.lines().collect(Collectors.joining("\n"));
                Files.write(Paths.get(pair.getKey()), pageText.getBytes());
                reader.close();
                q.put(pair.getKey());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class NamePrinter implements Runnable {
    private BlockingQueue q;
    private CountDownLatch latch;

    public NamePrinter(BlockingQueue q, CountDownLatch latch) {
        this.q = q;
        this.latch = latch;
    }

    @Override
    public void run() {
        String name;

        while (latch.getCount() != 0){
            try {
                if ((name = (String) q.poll()) != null){
                    System.out.println("Finished downloading: " + name);
                    latch.countDown();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
