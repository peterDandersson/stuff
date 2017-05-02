package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String,String> filesToLoad = new HashMap();
        filesToLoad.put("google.html","http://www.google.se");
        filesToLoad.put("ixquick.html","https://www.ixquick.com/");
        filesToLoad.put("yandex.html","https://www.yandex.ru/");
        filesToLoad.put("yahoo.html","https://se.search.yahoo.com/");

        new DLoader(filesToLoad);
    }
}