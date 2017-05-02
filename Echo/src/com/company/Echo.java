package com.company;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Laptop on 2017-02-02.
 */
public class Echo {
    public Echo(String host, int port, String message) {

        String[] args = {"192.168.10.98","4331","Hello"};

        try (Socket client = new Socket(host, port)){
            client.setSoTimeout(10000);
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF(message);
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            String response = in.readUTF();
            client.close();
            System.out.println("Server responde with: " + response);
        } catch (UnknownHostException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
