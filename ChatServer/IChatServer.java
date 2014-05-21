package ChatServer;

import String;

public interface IChatServer {

  public void addUser(GeneralUser user);

  public void addRoomAdmin(AdminUser admin, List permissions);

  public void removeUser(int userID);

  public void removeAllUser(int roomID);

  public void removeRoom(int roomID);

  public List getRooms();

  public void joinRoom(int roomID, int userID);

  public void removeAllRooms(List rooms);

  public void creatRestirctedRoom(String title, String desc, List allowdUsers);

  public void createGenralRoom();

  public void sendMessage(ChatMessage message);

  public void leaveRoom(int roomID, int userID);

  public ChatServer getInstance();

  public void loadPersistanceConfigurations();

  public void blockUser(int userID, int blockedUserID);

}