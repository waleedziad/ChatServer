package ChatServer;

import java.util.ArrayList;

public interface IChatServer {

  public void addUser(GeneralUser user);

  public void addRoomAdmin(AdminUser admin, ArrayList permissions);

  public void removeUser(int userID);

  public void removeAllUser(int roomID);

  public void removeRoom(int roomID);

  public ArrayList getRooms();

  public void joinRoom(int roomID, int userID);

  public void removeAllRooms(ArrayList rooms);

  public void creatRestirctedRoom(String title, String desc, ArrayList allowdUsers);

  public void createGenralRoom(String title, String desc, ArrayList allowdUsers);

  public void sendMessage(ChatMessage message);

  public void leaveRoom(int roomID, int userID);

  public ChatServer getInstance();

  public void loadPersistanceConfigurations();

  public void blockUser(int userID, int blockedUserID);

}