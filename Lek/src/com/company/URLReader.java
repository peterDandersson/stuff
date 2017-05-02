package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


/**
 * Created by Laptop on 2017-02-01.
 */
public class URLReader {

    public URLReader() throws IOException {

        URL lexicon = new URL("http://www.gallerihandihand.se/");
        BufferedReader in = new BufferedReader(new InputStreamReader(lexicon.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null){
            System.out.println(inputLine);
        }
        in.close();
    }
}
