/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserverproject;

import ChatServer.ChatMessage;
import ChatServer.ChatServer;
import ChatServer.GeneralUser;


/**
 *
 * @author sony
 */
public class ChatServerProject {

   
    public static void main(String[] args) {
       ChatServer server = new ChatServer() ; 
       GeneralUser user = new GeneralUser();
       user.setName("waleed");
       user.setID(1);
        GeneralUser user2 = new GeneralUser();
       user2.setName("sender");
       user2.setID(2);
       ChatMessage m = new ChatMessage() ;
       m.setMessage("the first message sent");
       m.setSender(user2);      
       System.out.println(m);
       server.addUser(user);
       server.addUser(user2);
       server.sendMessage(m, user);
       
      server.listen(8080);   
       
    }
}
