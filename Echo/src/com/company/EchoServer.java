package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Laptop on 2017-02-02.
 */
public class EchoServer {
    public static void main(String[] args) {
        int port = 4333;
        if (args.length>0)
            port = Integer.parseInt(args[0]);


        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println(InetAddress.getLocalHost().getHostAddress() + " " + serverSocket.getLocalPort());
            while (true) {
                Socket server = serverSocket.accept();
                DataInputStream in = new DataInputStream(server.getInputStream());
                String word = in.readUTF();
                DataOutputStream out = new DataOutputStream(server.getOutputStream());

                out.writeUTF(word);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
