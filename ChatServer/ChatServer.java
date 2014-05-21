package ChatServer;

public class ChatServer implements IChatServer {

  public List<IRoom> rooms;

  public List<IUser> user;

  public ChatServer chatServer;

  public IPersistanceMechanism persistanceMechanism;

  public void addUser(GeneralUser user) {
  }

  public void addRoomAdmin(AdminUser admin, List permissions) {
  }

  public void removeUser(int userID) {
  }

  public void removeAllUser(int roomID) {
  }

  public void removeRoom(int roomID) {
  }

  public List getRooms() {
  return null;
  }

  public void joinRoom(int roomID, int userID) {
  }

  public void removeAllRooms(List rooms) {
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

}