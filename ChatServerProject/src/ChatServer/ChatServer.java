package ChatServer;

import PersistanceLayer.IPersistanceMechanism;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ChatServer implements IChatServer {

  public ArrayList<AbstractRoom> rooms;
  
  public ArrayList<AbstractUser> users;
  
  public ChatServer chatServer;
  
  public ServerSocket serverSocket ;
  
  public IPersistanceMechanism persistanceMechanism;

  public ChatServer()
  {
      rooms = new  ArrayList<AbstractRoom>() ;
      users = new ArrayList<AbstractUser>() ;
  }
  public void addUser(GeneralUser user) {
      users.add(user);
  }

  public void addRoomAdmin(AdminUser admin, ArrayList permissions) {
  
  }

  public void removeUser(int userID) {
      for(int i =0 ; i < users.size() ; i++)
      {
          if (users.get(i).id == userID ){ users.remove(i); break ;}
      }
  }

  public void removeAllUser(int roomID) {
      users.clear();
  }

  public void removeRoom(int roomID) {
      for(int i =0 ; i < rooms.size() ; i++)
      {
          if (rooms.get(i).id == roomID ){ rooms.remove(i); break ;}
      }
  }

  public ArrayList getRooms() {
  return rooms;
  }

  public void joinRoom(int roomID, int userID) {
      AbstractUser tmpUser = new AbstractUser(); ;
       for(int i =0 ; i < users.size() ; i++)
      {
          if (users.get(i).id == userID ){ tmpUser = users.get(i) ; break ;}
      }
       
       for(int i =0 ; i < rooms.size() ; i++)
      {
          if (rooms.get(i).id == roomID ){ rooms.get(i).users.add(tmpUser) ;}
      }
  }

  public void removeAllRooms(ArrayList rooms) {
      rooms.clear();
  }


  public void createGenralRoom(String title, String desc, ArrayList allowdUsers) {
       AbstractRoom room = new GeneralRoom();
      room.setTitle(title);
      room.setDecription(desc);
      room.users = allowdUsers ;
      rooms.add(room);
  }

  public void sendMessage(ChatMessage message, AbstractUser recipient) {
      recipient.Messages.add(message);
  }

  public void leaveRoom(int roomID, int userID) {
      AbstractUser tmpUser = new AbstractUser(); ;
       for(int i =0 ; i < users.size() ; i++)
      {
          if (users.get(i).id == userID ){ tmpUser = users.get(i) ; break ;}
      }
       
       for(int i =0 ; i < rooms.size() ; i++)
      {
          if (rooms.get(i).id == roomID ){ rooms.get(i).users.remove(tmpUser) ;}
      }
  }

  public ChatServer getInstance() {
  return chatServer;
  }

  public void loadPersistanceConfigurations() {
  }

  public void blockUser(int userID, int blockedUserID) {
  }

    @Override
    public void creatRestirctedRoom(String title, String desc, ArrayList allowdUsers) {
         AbstractRoom room = new RestrictedRoom();
      room.setTitle(title);
      room.setDecription(desc);
      room.users = allowdUsers ;
      rooms.add(room);
    }
    AbstractUser getUser(int userID)
    {
         AbstractUser tmpUser = new AbstractUser(); ;
       for(int i =0 ; i < users.size() ; i++)
      {
          if (users.get(i).id == userID ){ tmpUser = users.get(i) ; break ;}
      }
       return tmpUser ;
    }
    String parseInput(String input)
    {
        
        if (input.contains("get messages"))
        {
           String [] arr = input.split(" ");
           AbstractUser tmpUser = getUser(Integer.parseInt(arr[2]) );
           return tmpUser.Messages.toString() ; 
        }
         // else if (input.contains("create room"))
       
        return "unknown input";
    }
    public void listen(int portNum)
    {
        try {
             System.out.println("function begins ");
            serverSocket = new ServerSocket(portNum) ;
            Socket clientSocket = serverSocket.accept();
           BufferedReader inStream = new BufferedReader (new InputStreamReader (clientSocket.getInputStream()));
            PrintWriter outStream = new PrintWriter(clientSocket.getOutputStream(),true);
            String inLine,outLine ;
            //outStream.println("hey Client Talk to me !!!");
             System.out.println("before Loop ");
            while( true)
            {
                 System.out.println("in Loop ");
                 inLine = inStream.readLine() ;
                 if (inLine == null)break ;
                System.out.println("Client spoke ");
                System.out.println("He said :  "+inLine);
                outLine = parseInput(inLine);
                //outLine = "Hooorayy!!";
                System.out.println("i will tell him : "+outLine);
                outStream.println(outLine);
            }
             System.out.println("out of Loop ");
             serverSocket.close();
             clientSocket.close();
        } catch (IOException ex) {
             System.out.println("Exception !!! ");
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}