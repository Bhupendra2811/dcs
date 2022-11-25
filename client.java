
package com.example.dcs;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class client{
    public static void main (String[] arg) throws IOException {


        Socket socket = new Socket("localhost",4000);
        System.out.println("connected to server");
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        Scanner sc = new Scanner(System.in);
        String msg;

        do{
           msg= sc.nextLine();
           out.println(msg);//passing msg to server
           String response = in.readLine();//getting response from server
           System.out.println(response);

        }
        while(!msg.equals("exit"));
    }
}