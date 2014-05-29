/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserverclient;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class ChatServerClient {

    
    public static void main(String[] args) throws Exception {
        
        Socket socket = new Socket("192.168.1.144", 8080);
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
   
   int t = 10000000;
   String order = "G" ; 
   Scanner sc = new Scanner(System.in);
   
   while (order.equals("!") == false){
   order = sc.nextLine();
   out.println(order);
  
   String s = in.readLine();
   
   System.out.println("Server said : " +s);
   }
   socket.close();
       
    }
}