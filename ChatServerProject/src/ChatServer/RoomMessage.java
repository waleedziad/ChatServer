package ChatServer;

import java.util.ArrayList;

public class RoomMessage extends ChatMessage {

  public ArrayList roomList;

  public void RoomMessage(AbstractUser sender, AbstractRoom room, String message) {
      this.sender = sender ;
      roomList.add(room);
      this.message = message ;
  }

  public void RoomMessage(AbstractUser sender, ArrayList<AbstractRoom> roomList, String message) {
       this.sender = sender ;
      this.roomList = roomList ;
      this.message = message ;
  }

}