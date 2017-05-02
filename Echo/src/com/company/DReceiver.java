package com.company;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Laptop on 2017-02-02.
 */
public class DReceiver {


    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(3000);
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, 1024);

        System.out.println(InetAddress.getLocalHost().getHostAddress() + " " + ds.getLocalPort());
        System.out.println("Waiting for message");

        ds.receive(dp);

        System.out.println("Something Received");
        String str = new String(dp.getData(), 0, dp.getLength());
        System.out.println("Received: " + str);
        ds.close();
    }

}
