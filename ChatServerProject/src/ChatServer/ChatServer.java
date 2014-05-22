package ChatServer;

import PersistanceLayer.IPersistanceMechanism;
import java.util.ArrayList;

public class ChatServer implements IChatServer {

  public ArrayList<AbstractRoom> rooms;

  public ArrayList<AbstractUser> users;

  public ChatServer chatServer;

  public IPersistanceMechanism persistanceMechanism;

  public void addUser(GeneralUser user) {
      users.add(user);
  }

  public void addRoomAdmin(AdminUser admin, ArrayList permissions) {
  
  }

  public void removeUser(int userID) {
      for(int i =0 ; i < users.size() ; i++)
      {
          if (users.get(i).id == userID ){ users.remove(i); break ;}
      }
  }

  public void removeAllUser(int roomID) {
      users.clear();
  }

  public void removeRoom(int roomID) {
      for(int i =0 ; i < rooms.size() ; i++)
      {
          if (rooms.get(i).id == roomID ){ rooms.remove(i); break ;}
      }
  }

  public ArrayList getRooms() {
  return rooms;
  }

  public void joinRoom(int roomID, int userID) {

  }

  public void removeAllRooms(ArrayList rooms) {
      rooms.clear();
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
  return chatServer;
  }

  public void loadPersistanceConfigurations() {
  }

  public void blockUser(int userID, int blockedUserID) {
  }

    @Override
    public void creatRestirctedRoom(String title, String desc, ArrayList allowdUsers) {
        
    }

}