package com.company;

import sun.net.www.protocol.https.HttpsURLConnectionImpl;

import javax.net.ssl.HttpsURLConnection;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Laptop on 2017-02-01.
 */
public class URLn {
    public URLn() throws Exception {
        //URL url = new URL("http","www.gallerihandihand.se",80,"Billy Bob");
        //URL url = new URL("http://www.gallerihandihand.se/");
        URL url = new URL("http://www.lexicon.se/");

        System.out.println("protocol: " + url.getProtocol());
        System.out.println("authority = " + url.getAuthority());
        System.out.println("host = " + url.getHost());
        System.out.println("port = " + url.getPort());
        System.out.println("path = " + url.getPath());
        System.out.println("query = " + url.getQuery());
        System.out.println("filename = " + url.getFile());
        System.out.println("ref = " + url.getRef());

        URLConnection urlConnection = url.openConnection();

        System.out.println("ContentType = " + urlConnection.getContentType());
        System.out.println("Permission = " + urlConnection.getPermission().getName());

        Map<String,List<String>> headers = urlConnection.getHeaderFields();
        System.out.println(headers.toString());
        Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
        for (Map.Entry<String, List<String>> entry : entrySet) {
            String headerName = entry.getKey();
            System.out.println("Header Name:" + headerName);
            List<String> headerValues = entry.getValue();
            for (String value : headerValues) {
                System.out.print("Header value:" + value);
            }
            System.out.println();
        }

        System.out.println("hej");
        HttpsURLConnection httpConnection = (HttpsURLConnection) url.openConnection();
        httpConnection.setRequestMethod("POST");
        httpConnection.setDoOutput(true);
        OutputStream os = httpConnection.getOutputStream();
        os.write("userName=Someone".getBytes());
        os.flush();
        os.close();

        System.out.println("hej");
        int responseCode = httpConnection.getResponseCode();


        System.out.println();
        String s = "abc & ? åäö";
        String encodedString = URLEncoder.encode(s, "UTF-8");
        System.out.println("URLEncoded = " +  encodedString);

        System.out.println("URLDecoded = " +  URLDecoder.decode( encodedString, "UTF-8"));
    }
}
