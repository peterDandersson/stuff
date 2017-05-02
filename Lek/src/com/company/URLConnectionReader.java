package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

/**
 * Created by Laptop on 2017-02-01.
 */
public class URLConnectionReader{
    public URLConnectionReader() throws Exception {
        URL lexicon = new URL("http://www.lexicon.se/");
        URLConnection con = lexicon.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null){
            System.out.println(inputLine);
        }
        in.close();
    }
}
