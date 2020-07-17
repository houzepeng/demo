package com.example.demo.algorithm;
import java.net.*;
import java.io.*;//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/java/java_networking.html


public class GreetingClient {
    public static void main(String [] args) {
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);
        try {
           System.out.println("Connecting to " + serverName + " on port " + port);
           Socket client = new Socket(serverName, port);
  
           System.out.println("Just connected to " + client.getRemoteSocketAddress());
           OutputStream outToServer = client.getOutputStream();
           DataOutputStream out = new DataOutputStream(outToServer);
  
           out.writeUTF("Hello from " + client.getLocalSocketAddress());
           InputStream inFromServer = client.getInputStream();
           DataInputStream in = new DataInputStream(inFromServer);
  
           System.out.println("Server says " + in.readUTF());
           client.close();
        } catch (IOException e) {
           e.printStackTrace();
        }
     }//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/java/java_networking.html
  
  
}