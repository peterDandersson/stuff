package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Peter
 */
public class TextSplitter {
    Map<String,String> map;

    public TextSplitter(String uri) {
        map = new HashMap<>();
        Path path = Paths.get(uri);

        try (InputStream in = Files.newInputStream(path);
             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                StringBuilder sb = new StringBuilder();
                StringBuilder key = new StringBuilder();

                for (int i = 0; i < line.length(); i++){
                    switch (line.charAt(i)){
                        case ':':   key = sb;
                                    sb = new StringBuilder();
                                    break;

                        default:    sb.append(line.charAt(i));
                                    break;
                    }
                }
                map.put(key.toString(),sb.toString());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public Map<String, String> getMap() {
        return map;
    }
}
