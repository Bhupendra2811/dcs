package com.example.dcs;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDPServer {
    public static  void main(String[] args) throws IOException {

        DatagramSocket dgs = new DatagramSocket(4000);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        DatagramPacket dgp = new DatagramPacket(receiveData, receiveData.length);
        dgs.receive(dgp);
        String str = new String(dgp.getData());
        System.out.println("Data Received: " + str);
        InetAddress ia = InetAddress.getLocalHost();
        StringBuffer rev = new StringBuffer();
        rev = rev.append(str);
        rev = rev.reverse();
//        System.out.println(rev);
        String result = new String(rev);
//        System.out.println(result);
        sendData = result.getBytes();
        dgp = new DatagramPacket(sendData, sendData.length, ia, dgp.getPort());
        dgs.send(dgp);
            if (str.equals("bye"))
            {
                System.out.println("Client sent bye.....EXITING");
            }
        }
}
