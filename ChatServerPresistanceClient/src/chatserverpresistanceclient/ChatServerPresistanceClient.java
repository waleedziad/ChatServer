/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserverpresistanceclient ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Ahmed abdl hammed
 */
class AbstractUser
{
 public int id;

  public String name;

  public void setID(int userID) {
      id = userID ;
  }

  public int getID() {
  return id;
  }

  public void setName(String userName) {
      name = userName ;
  }

  public String getName() {
  return name;
  }    
}

class AbstractRoom {

  public String title;

  public String desciption;

  public ArrayList<AbstractUser> users ;

  public int id;

    public AbstractRoom() {
        users = new ArrayList<AbstractUser> () ;
    }

  
  public void setTitle(String title) {
      this.title = title ;
  }

  public String getTitle() {
  return title;
  }

  public void setDecription(String desc) {
      desciption = desc ;
  }

  public String getDesciption() {
  return desciption;
  }

  public ArrayList getUsers() {
  return users;
  }

  public void setID(int roomId) {
      id = roomId ;
  }

  public int getID() {
  return id ;
  }

}
public class ChatServerPresistanceClient {
  
    public AbstractUser getUser(int UserID) {
     Connection conn = null;
     AbstractUser User = new AbstractUser();
     User.setID(UserID);
     String url = "jdbc:mysql://127.0.0.1:3306/";
     String dbName = "chatserver";
     String driver = "com.mysql.jdbc.Driver";
     String userName = "root";
     String password = "";
 
     ArrayList<String> s = new ArrayList<String>();

   try {
     Class.forName(driver).newInstance();
     conn = DriverManager.getConnection(url+dbName,userName,password);
     System.out.println("Connected to the database");
  
   Statement stmt = conn.createStatement() ;
   String query = "select * from chatserver.user; ";
   ResultSet rs = stmt.executeQuery(query) ;
   
   while (rs.next())
                   {
                      if (Integer.toString(User.getID()).equals(rs.getString(1))) 
                      {
                          User.setName(rs.getString(2));
                          
                      }
                   }
   
    conn.close();
    System.out.println("Disconnected from database");
      } 
      catch (Exception e) {
       System.out.println("NO CONNECTION =("+e);
     }
      return User;
 }   
public void addUser(int userID, AbstractUser user,int roomID) {
  
  Connection conn = null;
     
     user.setID(userID);
     
     String url = "jdbc:mysql://127.0.0.1/";
     String dbName = "chatserver";
     String driver = "com.mysql.jdbc.Driver";
     String userName = "root";
     String password = "";
 

   try {
     Class.forName(driver).newInstance();
     conn = DriverManager.getConnection(url+dbName,userName,password);
     System.out.println("Connected to the database");
  
    Statement stmt = conn.createStatement() ;
    String query = "INSERT INTO user (UserID,UserName,RoomID)\n" +"VALUES ("+userID+",'"+user.getName()+"',"+roomID+");";
    //System.out.print(query);
   
    stmt.executeUpdate(query) ;
   
   
    conn.close();
      
    System.out.println("Disconnected from database");
      } 
      catch (Exception e) {
       System.out.println("NO CONNECTION =(");
     }
 }
    public void deleteUser(int userID) {
    
    Connection conn = null;
     
     String url = "jdbc:mysql://127.0.0.1/";
     String dbName = "chatserver";
     String driver = "com.mysql.jdbc.Driver";
     String userName = "root";
     String password = "";
 

   try {
     Class.forName(driver).newInstance();
     conn = DriverManager.getConnection(url+dbName,userName,password);
     System.out.println("Connected to the database");
  
    Statement stmt = conn.createStatement() ;
    
    String query = "delete from user where "+userID+"= UserID;";
   
    stmt.executeUpdate(query);
   
    conn.close();
      
    System.out.println("Disconnected from database");
      } 
      catch (Exception e) {
       System.out.println("NO CONNECTION =(");
     }
 }
    
    public void addRoom(int userID, AbstractRoom room) {
     
     Connection conn = null;
     
     
     
     String url = "jdbc:mysql://127.0.0.1/";
     String dbName = "chatserver";
     String driver = "com.mysql.jdbc.Driver";
     String userName = "root";
     String password = "";
 

   try {
     Class.forName(driver).newInstance();
     conn = DriverManager.getConnection(url+dbName,userName,password);
     System.out.println("Connected to the database");
  
     Statement stmt = conn.createStatement() ;
    
     String query = "INSERT INTO room (RoomID,RoomName,RoomAdminID,RoomDesc)\n" +"VALUES ("+room.getID()+",'"+room.getTitle()+"',"+userID+",'"+room.getDesciption()+"');";
     System.out.println(query);
     stmt.executeUpdate(query);
   
     conn.close();
      
     System.out.println("Disconnected from database");
      } 
      catch (Exception e) {
       System.out.println("NO CONNECTION =(");
     }
   }
    public AbstractRoom getRoom(int RoomID) {
      
     Connection conn = null;
     AbstractRoom Room = new AbstractRoom();
     Room.setID(RoomID);
     String url = "jdbc:mysql://127.0.0.1/";
     String dbName = "chatserver";
     String driver = "com.mysql.jdbc.Driver";
     String userName = "root";
     String password = "";
     ArrayList<Integer> UserIDs = new ArrayList<Integer>();
     ArrayList<String> UserNames = new ArrayList<String>();
    

   try {
     Class.forName(driver).newInstance();
     conn = DriverManager.getConnection(url+dbName,userName,password);
     System.out.println("Connected to the database");
  
     Statement stmt = conn.createStatement() ;
     String query = "select * from room; ";
     ResultSet rs = stmt.executeQuery(query) ;
   
   while (rs.next())
                   {
                      if (Integer.toString(Room.getID()).equals(rs.getString(1))) 
                      {
                          Room.setTitle(rs.getString(2));
                          Room.setDecription(rs.getString(4));                      
                      }
                   }
    
    query = "select * from user where RoomID = "+RoomID+";";
    ResultSet rs_user = stmt.executeQuery(query) ;
    
    while (rs_user.next())
                   {
                          //System.out.println(rs_user.getArray(User));
                          UserIDs.add(Integer.parseInt(rs_user.getString(1)));
                          UserNames.add(rs_user.getString(2));
                          //Room.users.add(User);
                   }
    
    
    conn.close();
    
    //System.out.println(Room.getUsers());
    System.out.println("Disconnected from database");
      } 
      catch (Exception e) {
       System.out.println("NO CONNECTION =(");
     }
     //Room.users.size() = UserIDs.size() ;
   for (int i=0 ; i < UserIDs.size() ; i++)
     {
        AbstractUser User = new AbstractUser(); 
        User.setID(UserIDs.get(i));
        User.setName(UserNames.get(i));
        Room.users.add(User);
     }
    for (int i=0 ; i < Room.users.size() ; i++) 
    {
        System.out.println(Room.users.get(i).getID()+" "+Room.users.get(i).getName());
    }
    
     return Room;
  }
    
    public void deleteRoom(int roomID) {
      
     Connection conn = null;
     
     String url = "jdbc:mysql://127.0.0.1/";
     String dbName = "chatserver";
     String driver = "com.mysql.jdbc.Driver";
     String userName = "root";
     String password = "";
 

   try {
     Class.forName(driver).newInstance();
     conn = DriverManager.getConnection(url+dbName,userName,password);
     System.out.println("Connected to the database");
  
     Statement stmt = conn.createStatement() ;
    
     String query = "delete from room where "+roomID+"= RoomID;";
   
     stmt.executeUpdate(query);
   
     conn.close();
      
       System.out.println("Disconnected from database");
     } 
      catch (Exception e) {
       System.out.println("NO CONNECTION =(");
     }
  
  }
    
    public ArrayList<AbstractUser> getAllUsers(int roomID) {
      
      Connection conn = null;
      
      String url = "jdbc:mysql://127.0.0.1/";
      String dbName = "chatserver";
      String driver = "com.mysql.jdbc.Driver";
      String userName = "root";
      String password = "";
      ArrayList<Integer> UserIDs = new ArrayList<Integer>();
      ArrayList<String> UserNames = new ArrayList<String>();
      ArrayList<AbstractUser> Users = new ArrayList<AbstractUser>();

   try {
     Class.forName(driver).newInstance();
     conn = DriverManager.getConnection(url+dbName,userName,password);
     System.out.println("Connected to the database");
  
     Statement stmt = conn.createStatement() ;
     
     String query = "select * from user where RoomID = "+roomID+";";
     ResultSet rs = stmt.executeQuery(query) ;
    
    while (rs.next())
                   
    {
                          
                          UserIDs.add(Integer.parseInt(rs.getString(1)));
                          UserNames.add(rs.getString(2));
                          
                   }
    
    
    conn.close();
    
   
    System.out.println("Disconnected from database");
      } 
      catch (Exception e) {
       System.out.println("NO CONNECTION =(");
     }
     
   for (int i=0 ; i < UserIDs.size() ; i++)
     {
        AbstractUser User = new AbstractUser(); 
        User.setID(UserIDs.get(i));
        User.setName(UserNames.get(i));
        Users.add(User);
     }
    
   for (int i=0 ; i < Users.size() ; i++) 
    {
        System.out.println(Users.get(i).getID()+" "+Users.get(i).getName());
    }
      
   return Users;  
  }      
    public ArrayList<AbstractRoom> getAllRooms() {
  
     Connection conn = null;
     String url = "jdbc:mysql://127.0.0.1/";
     String dbName = "chatserver";
     String driver = "com.mysql.jdbc.Driver";
     String userName = "root";
     String password = "";
     ArrayList<Integer> RoomIDs = new ArrayList<Integer>();
     ArrayList<String> RoomTitles = new ArrayList<String>();
     ArrayList<String> RoomDescs = new ArrayList<String>();
     ArrayList<AbstractRoom> Rooms = new ArrayList<AbstractRoom>();

   try {
     Class.forName(driver).newInstance();
     conn = DriverManager.getConnection(url+dbName,userName,password);
     System.out.println("Connected to the database");
  
     Statement stmt = conn.createStatement() ;
     String query = "select * from room; ";
     ResultSet rs = stmt.executeQuery(query) ;
   
   while (rs.next())
                   {
                          RoomIDs.add(Integer.parseInt(rs.getString(1)));
                          RoomTitles.add(rs.getString(2));
                          RoomDescs.add(rs.getString(4));                        
                   }
   
    
   for (int j=0 ; j < RoomIDs.size(); j++) 
   {
    ArrayList<Integer> UserIDs = new ArrayList<Integer>();
    ArrayList<String> UserNames = new ArrayList<String>();     
    query = "select * from user where RoomID = "+RoomIDs.get(j)+";";
    ResultSet rs_user = stmt.executeQuery(query) ;
    
    while (rs_user.next())
                   {
                          
                          UserIDs.add(Integer.parseInt(rs_user.getString(1)));
                          UserNames.add(rs_user.getString(2));
                          
                   }
        AbstractRoom Room = new AbstractRoom(); 
        Room.setID(RoomIDs.get(j));
        Room.setTitle(RoomTitles.get(j));
        Room.setDecription(RoomDescs.get(j));
        
    for (int i=0 ; i < UserIDs.size() ; i++)
     {
        AbstractUser User = new AbstractUser(); 
        User.setID(UserIDs.get(i));
        User.setName(UserNames.get(i));
        Room.users.add(User);
     }
    Rooms.add(Room);
   }
    
    conn.close();
    
   
    System.out.println("Disconnected from database");
      } 
      catch (Exception e) {
       System.out.println("NO CONNECTION =(");
     }
     
    
     return Rooms;  
  }
    
    public static void main(String[] args) throws SQLException {
        
        ChatServerPresistanceClient j = new ChatServerPresistanceClient();
        int RoomID = 0;   
        AbstractUser User = new AbstractUser();
        User.setID(0);
        User.setName("Hady");
        int userID = User.getID();
        j.addUser(userID, User,RoomID);
            
        User = j.getUser(0);
        int s2 = User.getID();
        String s1 = User.getName();
        System.out.println(s2+" "+s1);
        System.out.println("");
        
        
        //j.deleteUser(3);
        
        /*AbstractRoom Room = new AbstractRoom();
        int AdminID = 0;
        int RoomID = 2;
        String RoomDesc = "its a group about hamada";
        String RoomTitle = "Hamada";
        Room.setID(RoomID);
        Room.setTitle(RoomTitle);
        Room.setDecription(RoomDesc);
        j.addRoom(AdminID, Room);
        */
        
        //j.getRoom(0);
        
        //j.deleteRoom(1);
        
        //j.getAllUsers(0);
        
        /*ArrayList<AbstractRoom> Room = new ArrayList<AbstractRoom>();
        Room = j.getAllRooms();
        for (int i=0 ; i < Room.size() ; i++)
        {
          System.out.println(Room.get(i).getID()+" "+Room.get(i).getTitle()+" "+Room.get(i).getDesciption()+"\n");
          for (int k=0 ; k < Room.get(i).users.size(); k++) 
          {    
          System.out.println(Room.get(i).users.get(k).getID()+" "+Room.get(i).users.get(k).getName());
          }
        }*/
    }

}