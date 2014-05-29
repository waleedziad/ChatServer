package ChatServer;

import ExceptionLayer.MessageNotSentException;
import java.util.ArrayList;

public interface IChatServer {

  public void addUser(GeneralUser user)throws Exception ;

  public void addRoomAdmin(AdminUser admin, ArrayList permissions);

  public void removeUser(int userID)throws Exception ;

  public void removeAllUser(int roomID);

  public void removeRoom(int roomID)throws Exception ;

  public ArrayList getRooms();

  public void joinRoom(int roomID, int userID)throws Exception ;

  public void removeAllRooms(ArrayList rooms);

  public void creatRestirctedRoom(String title, String desc, ArrayList allowdUsers);

  public void createGenralRoom(String title, String desc, ArrayList allowdUsers)throws Exception ;

  public void sendMessage(ChatMessage message ,AbstractUser recipient) throws MessageNotSentException ;

  public void leaveRoom(int roomID, int userID);

  
  

  public void loadPersistanceConfigurations();

  public void blockUser(int userID, int blockedUserID);

}