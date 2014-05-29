package PersistanceLayer;

import ChatServer.AbstractRoom;
import ChatServer.AbstractUser;
import ExceptionLayer.SQLException;
import java.util.ArrayList;

public interface IPersistanceMechanism {

  public void addUser(int userID, AbstractUser user, int roomID) throws SQLException;

  public AbstractUser getUser(int UserID)throws SQLException;

  public void deleteUser(int userID)throws SQLException;

  public void addRoom(int userID, AbstractRoom room)throws SQLException;

  public AbstractRoom getRoom(int RoomID)throws SQLException;

  public void deleteRoom(int roomID)throws SQLException;

  public ArrayList<AbstractRoom> getAllRooms()throws SQLException;

  public ArrayList<AbstractUser> getAllUsers(int roomID)throws SQLException;


  

}