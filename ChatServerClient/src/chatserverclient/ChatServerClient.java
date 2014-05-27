/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserverclient;

import java.io.*;
import java.net.Socket;


public class ChatServerClient {

    
    public static void main(String[] args) throws Exception {
        
        Socket socket = new Socket("localhost", 8080);
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
   
   int t = 10000000;
   out.println("get messages 1");
   //System.out.println("request sent !!!"); 
   //while(true){out.print("get messages 1");System.out.print("get messages 1");}
   String s = in.readLine();
   
   System.out.println("Server said : " +s);
   socket.close();
       
    }
}
