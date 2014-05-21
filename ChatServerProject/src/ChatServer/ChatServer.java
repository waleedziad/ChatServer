package ChatServer;

import PersistanceLayer.IPersistanceMechanism;
import java.util.ArrayList;

public class ChatServer implements IChatServer {

  public ArrayList<AbstractRoom> rooms;

  public ArrayList<AbstractUser> user;

  public ChatServer chatServer;

  public IPersistanceMechanism persistanceMechanism;

  public void addUser(GeneralUser user) {
  }

  public void addRoomAdmin(AdminUser admin, ArrayList permissions) {
  }

  public void removeUser(int userID) {
  }

  public void removeAllUser(int roomID) {
  }

  public void removeRoom(int roomID) {
  }

  public ArrayList getRooms() {
  return null;
  }

  public void joinRoom(int roomID, int userID) {
  }

  public void removeAllRooms(ArrayList rooms) {
  }

  public void creatRestirctedRoom() {
  }

  public void createGenralRoom() {
  }

  public void sendMessage(ChatMessage message) {
  }

  public void leaveRoom(int roomID, int userID) {
  }

  public ChatServer getInstance() {
  return null;
  }

  public void loadPersistanceConfigurations() {
  }

  public void blockUser(int userID, int blockedUserID) {
  }

    @Override
    public void creatRestirctedRoom(String title, String desc, ArrayList allowdUsers) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}