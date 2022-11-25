package com.example.dcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main (String[] arg) throws IOException {


        ServerSocket socket = new ServerSocket(4000);
        System.out.println("Waiting for client connection");
        Socket clientSocket = socket.accept();
        System.out.println("Client Connected");
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
        String msg;
        do{
            msg= in.readLine();
            System.out.println("cleint sent "+msg);
            int i1 = Integer.parseInt(msg);
            int i2 = i1 + 2;
            String a = String.valueOf(i2);
            System.out.println(i2);

            out.println("result " + a);
        }while(!msg.equals("exit"));
    }

}
