package PersistanceLayer;

import ChatServer.AbstractRoom;
import ChatServer.AbstractUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLPersistance implements IPersistanceMechanism {

  public SQLPersistance instance;

  
  public void addUser(int userID, AbstractUser user, int roomID) {
  
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
   
    stmt.executeUpdate(query);
   
    conn.close();
      
    System.out.println("Disconnected from database");
      } 
      catch (Exception e) {
       System.out.println("NO CONNECTION");
     }
 }
  

  
  public AbstractUser getUser(int UserID) {
     
     Connection conn = null;
     AbstractUser User = new AbstractUser();
     User.setID(UserID);
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
   String query = "select * from user; ";
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
       System.out.println("NO CONNECTION");
     }
      return User;
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
       System.out.println("NO CONNECTION");
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
   
     stmt.executeUpdate(query);
   
     conn.close();
      
     System.out.println("Disconnected from database");
      } 
      catch (Exception e) {
       System.out.println("NO CONNECTION");
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
                          
                          UserIDs.add(Integer.parseInt(rs_user.getString(1)));
                          UserNames.add(rs_user.getString(2));
                          
                   }
    
    
    conn.close();
    
   
    System.out.println("Disconnected from database");
      } 
      catch (Exception e) {
       System.out.println("NO CONNECTION");
     }
     
   for (int i=0 ; i < UserIDs.size() ; i++)
     {
        AbstractUser User = new AbstractUser(); 
        User.setID(UserIDs.get(i));
        User.setName(UserNames.get(i));
        Room.users.add(User);
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
       System.out.println("NO CONNECTION");
     }
  
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
       System.out.println("NO CONNECTION");
     }
     
    
     return Rooms;  
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
       System.out.println("NO CONNECTION");
     }
     
   for (int i=0 ; i < UserIDs.size() ; i++)
     {
        AbstractUser User = new AbstractUser(); 
        User.setID(UserIDs.get(i));
        User.setName(UserNames.get(i));
        Users.add(User);
     }
    
     return Users;  
  }      
     
  public IPersistanceMechanism getInstance() {
  return instance;
  }

   
}