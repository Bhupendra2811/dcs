package com.example.dcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        InetAddress ia = InetAddress.getLocalHost();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte[] buf = null;
        while (true)
        {
            String inp = br.readLine();
            // convert the String input into the byte array.
            System.out.println(inp);
            buf = inp.getBytes();

            // Step 2 : Create the datagramPacket for sending
            // the data.
            DatagramPacket DpSend =
                    new DatagramPacket(buf, buf.length,ia,4000) ;

            // Step 3 : invoke the send call to actually send
            // the data.
            ds.send(DpSend);

            byte [] b1 = new byte[1024];
            DatagramPacket dp1 = new DatagramPacket(b1,b1.length);
            ds.receive(dp1);
            String data = new String(dp1.getData());
            if(inp.equals(data)){
                System.out.println("this is a palindrome");
            }
            else{
                System.out.println("not a palindrome");
            }
            // break the loop if user enters "bye"
            if (inp.equals("bye"))
                break;
        }


    }
}