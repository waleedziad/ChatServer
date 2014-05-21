package Persistance Layer;

import ChatServer.int;
import ChatServer.List<AbstractUser>;
import ChatServer.IPersistanceMechanism;
import ChatServer.AbstractRoom;
import ChatServer.AbstractUser;

public interface IPersistanceMechanism {

  public void addUser(int userID, AbstractUser user);

  public AbstractUser getUser();

  public void deleteUser(int userID);

  public void addRoom(int userID, AbstractRoom room);

  public AbstractRoom getRoom();

  public void deleteRoom(int roomID);

  public List<AbstractRoom> getAllRooms();

  public List<AbstractUser> getAllUsers(int roomID);

  public IPersistanceMechanism getInstance();

}