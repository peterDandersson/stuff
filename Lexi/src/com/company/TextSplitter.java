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
    Map<String,List<String>> map;

    public TextSplitter() {
        map = new HashMap<>();
        Path path = Paths.get("thesaurus-sv_utf8.txt");

        try (InputStream in = Files.newInputStream(path);
             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {

                boolean isKey = true;
                StringBuilder sb = new StringBuilder();
                String key = "";
                for (int i = 0; i < line.length(); i++) {

                    if (line.charAt(i) != ':' && isKey) {
                        sb.append(line.charAt(i));
                    } else if (line.charAt(i) == ':') {
                        isKey = false;
                        key = sb.toString();
                        map.put(key, new ArrayList<String>());
                        sb = new StringBuilder();
                    } else {
                        if (line.charAt(i) != ',' && i != (line.length()) -1) {
                            sb.append(line.charAt(i));
                        } else {
                            if(line.length() -1 == i){
                                sb.append(line.charAt(i));
                            }
                            map.get(key).add(sb.toString());
                            sb = new StringBuilder();
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public Map<String, List<String>> getMap() {
        return map;
    }
}
