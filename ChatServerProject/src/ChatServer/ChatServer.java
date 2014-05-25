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
      AbstractUser tmpUser = new AbstractUser(); ;
       for(int i =0 ; i < users.size() ; i++)
      {
          if (users.get(i).id == userID ){ tmpUser = users.get(i) ; break ;}
      }
       
       for(int i =0 ; i < rooms.size() ; i++)
      {
          if (rooms.get(i).id == roomID ){ rooms.get(i).users.add(tmpUser) ;}
      }
  }

  public void removeAllRooms(ArrayList rooms) {
      rooms.clear();
  }


  public void createGenralRoom(String title, String desc, ArrayList allowdUsers) {
       AbstractRoom room = new GeneralRoom();
      room.setTitle(title);
      room.setDecription(desc);
      room.users = allowdUsers ;
      rooms.add(room);
  }

  public void sendMessage(ChatMessage message) {
  }

  public void leaveRoom(int roomID, int userID) {
      AbstractUser tmpUser = new AbstractUser(); ;
       for(int i =0 ; i < users.size() ; i++)
      {
          if (users.get(i).id == userID ){ tmpUser = users.get(i) ; break ;}
      }
       
       for(int i =0 ; i < rooms.size() ; i++)
      {
          if (rooms.get(i).id == roomID ){ rooms.get(i).users.remove(tmpUser) ;}
      }
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
         AbstractRoom room = new RestrictedRoom();
      room.setTitle(title);
      room.setDecription(desc);
      room.users = allowdUsers ;
      rooms.add(room);
    }

}