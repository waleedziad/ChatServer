package PersistanceLayer;

import ChatServer.AbstractRoom;
import ChatServer.AbstractUser;
import java.util.ArrayList;

public class SQLPersistance implements IPersistanceMechanism {

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

  public ArrayList<AbstractRoom> getAllRooms() {
  return null;
  }

  public ArrayList<AbstractUser> getAllUsers(int roomID) {
  return null;
  }

  public IPersistanceMechanism getInstance() {
  return null;
  }

}