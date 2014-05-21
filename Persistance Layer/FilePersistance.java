package Persistance Layer;

import ChatServer.int;
import ChatServer.List<AbstractUser>;
import ChatServer.IPersistanceMechanism;
import ChatServer.AbstractRoom;
import ChatServer.AbstractUser;

public class FilePersistance implements IPersistanceMechanism {

  public SQLPersistance instance;

  public void addUser(int userID, AbstractUser user) {
  }

  public AbstractUser getUser() {
  return null;
  }

  public void deleteUser(int userID) {
  }

  public void addRoom(int userID, AbstractRoom room) {
  }

  public AbstractRoom getRoom() {
  return null;
  }

  public void deleteRoom(int roomID) {
  }

  public List<AbstractRoom> getAllRooms() {
  return null;
  }

  public List<AbstractUser> getAllUsers(int roomID) {
  return null;
  }

  public IPersistanceMechanism getInstance() {
  return null;
  }

}