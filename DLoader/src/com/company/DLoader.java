package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Created by Laptop on 2017-01-20.
 */
public class DLoader {
    DLoader(){

        Thread t1 = new Thread(() -> {
            String a = "";
            int lines = 30;
            for (int i = 0; i < lines; i++){
                a += "*";
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(a);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                final URL url = new URL("http://www.google.se");
                final URLConnection conn = url.openConnection();
                final BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                final String pageText = reader.lines().collect(Collectors.joining("\n"));
                Files.write(Paths.get("test.html"), pageText.getBytes());
                reader.close();
            }
            catch (IOException e) {
                System.err.println(e.getMessage());
            }
        });
    }
}
