package ChatServer;

import PersistanceLayer.IPersistanceMechanism;
import PersistanceLayer.SQLPersistance;
import com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ChatServer implements IChatServer {

  public  static final int sqlPresistanceChoice = 1 ;
     
  public  static final int filePresistanceChoice = 2 ;
  public ArrayList<AbstractRoom> rooms;
  
  public ArrayList<AbstractUser> users;
  
  private static ChatServer chatServer;
  
  public ServerSocket serverSocket ;
  
  public IPersistanceMechanism persistanceMechanism;
  PersistanceLayer.PersistanceFActory factory ;
  private ChatServer()
  {
     persistanceMechanism = factory.loadPersistanceMechanism(sqlPresistanceChoice);
     rooms = persistanceMechanism.getAllRooms();
     users = persistanceMechanism.getAllUsers(1);
  }
  public void addUser(GeneralUser user) {
      users.add(user);
      persistanceMechanism.addUser(user.id, user, 1);
  }

  public void addRoomAdmin(AdminUser admin, ArrayList permissions) {
      
  
  }

  public void removeUser(int userID) {
      for(int i =0 ; i < users.size() ; i++)
      {
          if (users.get(i).id == userID ){ users.remove(i);  break ;}
      }
      persistanceMechanism.deleteUser(userID);
      
  }

  public void removeAllUser(int roomID) {
      users.clear();
      
  }

  public void removeRoom(int roomID) {
      for(int i =0 ; i < rooms.size() ; i++)
      {
          if (rooms.get(i).id == roomID ){ rooms.remove(i); break ;}
      }
      persistanceMechanism.deleteRoom(roomID);
  }

  public ArrayList getRooms() {
  return rooms;
  }

  @Override
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
       persistanceMechanism.addUser(userID, getUser(userID), roomID);
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
      persistanceMechanism.addRoom(1, room);
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

  public static ChatServer getInstance() {
      if (chatServer == null)chatServer = new ChatServer();
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
         String [] arr = input.split(" ");
         try {
        if (input.contains("get messages"))
        {
          
           AbstractUser tmpUser = getUser(Integer.parseInt(arr[2]) );
           return tmpUser.Messages.toString() ; 
        }
          else if (input.contains("create room genral"))
          {
              ArrayList<AbstractUser> tmpusers = new ArrayList<AbstractUser>();
              for(int i =5 ; i < arr.length ; i++ )tmpusers.add(getUser(Integer.parseInt(arr[i])));
              createGenralRoom(arr[3],arr[4],tmpusers);
              return "room created successfully !!";
          }
          else if (input.contains("send message"))
          {
              int i = 0 ;
              String msg = "" ;
              for( i = 3 ; arr[i].equals("|") == false ; i++)msg+=arr[i] ;
              ChatMessage m = new ChatMessage();
              
              m.sender = getUser( Integer.parseInt(arr[i+1]));
              m.message = msg ;
              
              sendMessage(m, getUser( Integer.parseInt(arr[i+2])));
              return "message sent sucessfully !!" ;
              //("send message "|" message body "|" senderId ReciepentId 
          }
          else if (input.contains("get rooms"))
          {
              
              return getRooms().toString();
          }
          
          else if (input.contains("join room"))
          {
              String RoomID = arr[2];
              String UserID = arr[3];
              joinRoom(Integer.parseInt(RoomID), Integer.parseInt(UserID));
              return "Room joined successfully !!";
          }
          else if (input.contains("leave room"))
          {
              String RoomID = arr[2];
              String UserID = arr[3];
              leaveRoom(Integer.parseInt(RoomID), Integer.parseInt(UserID));
              return "You left the room successfully !!";
          }
          
          else if (input.contains("create restricted room"))
          {
              ArrayList<AbstractUser> tmpusers = new ArrayList<AbstractUser>();
              for(int i =5 ; i < arr.length ; i++ )tmpusers.add(getUser(Integer.parseInt(arr[i])));
              creatRestirctedRoom(arr[3],arr[4],tmpusers);
              return "room created successfully !!";
          }
          else if (input.contains("get user"))
          {
              String UserID = arr[2];
              return getUser(Integer.parseInt(UserID)).toString();
          }
         }
         catch(Exception e)
         {
             return "unknown input";
         }
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