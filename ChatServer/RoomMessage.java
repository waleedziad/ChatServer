package ChatServer;

import String;

public class RoomMessage extends ChatMessage {

  public List roomList;

  public void RoomMessage(IUser sender, IRoom room, String message) {
  }

  public void RoomMessage(IUser sender, List<IRoom> roomList, String message) {
  }

}