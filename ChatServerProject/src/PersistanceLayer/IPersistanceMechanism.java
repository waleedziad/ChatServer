package PersistanceLayer;

import ChatServer.AbstractRoom;
import ChatServer.AbstractUser;
import java.util.ArrayList;

public interface IPersistanceMechanism {

  public void addUser(int userID, AbstractUser user);

  public AbstractUser getUser();

  public void deleteUser(int userID);

  public void addRoom(int userID, AbstractRoom room);

  public AbstractRoom getRoom();

  public void deleteRoom(int roomID);

  public ArrayList<AbstractRoom> getAllRooms();

  public ArrayList<AbstractUser> getAllUsers(int roomID);

  public IPersistanceMechanism getInstance();

}