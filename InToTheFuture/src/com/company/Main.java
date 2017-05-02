package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future f = executorService.submit(new CallBack());
        System.out.println("Då väntar vi då...");

        while (!f.isDone()){
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("...och väntar...");
        }
        try {
            System.out.println(""+f.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}

class CallBack implements Callable {
    @Override
    public Object call() throws Exception {
        final URL url = new URL("http://www.google.se");
        final URLConnection conn = url.openConnection();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        final String pageText = reader.lines().collect(Collectors.joining("\n"));
        Path p = Files.write(Paths.get("google.html"), pageText.getBytes());
        reader.close();

        return p.getRoot();
    }
}
