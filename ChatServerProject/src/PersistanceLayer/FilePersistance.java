package PersistanceLayer;

import ChatServer.AbstractRoom;
import ChatServer.AbstractUser;
import java.util.ArrayList;

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

  public ArrayList<AbstractRoom> getAllRooms() {
  return null;
  }

  public ArrayList<AbstractUser> getAllUsers(int roomID) {
  return null;
  }

  public IPersistanceMechanism getInstance() {
  return null;
  }

    @Override
    public void addUser(int userID, AbstractUser user, int roomID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AbstractUser getUser(int UserID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AbstractRoom getRoom(int RoomID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}