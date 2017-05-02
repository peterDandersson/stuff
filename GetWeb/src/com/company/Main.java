package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
	    List<Page> pages = new ArrayList<>();
	    String urlString = "http://www.lexicon.se/";
	    Page lexicon = URLPageLoader(urlString);

        System.out.println(lexicon.getContent());
        for (String link: lexicon.getLinks()){
            System.out.println(link);
            try {
                pages.add(URLPageLoader(link));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        for (Page p: pages){
            System.out.println(p.getLinks());
        }
    }

    public static Page URLPageLoader(String urlString) throws IOException {
        
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        URL url = new URL(urlString);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null){
            //System.out.println(inputLine + "LINE!!!");

            sb.append(inputLine + "\n");
            if(inputLine.contains("href=\"http")) {
                StringBuilder newLink = new StringBuilder();
                int start = inputLine.indexOf("href=") + 6;
                while (inputLine.charAt(start) != '"'){
                    newLink.append(inputLine.charAt(start));
                    start++;
                }
                list.add(newLink.toString());
            }
        }
        in.close();
        return new Page(list,sb.toString());
    }
}

class Page {
    private List<String> links;
    private String content;

    public Page(List<String> links, String content) {
        this.links = links;
        this.content = content;
    }

    public List<String> getLinks() {
        return links;
    }

    public String getContent() {
        return content;
    }
}
