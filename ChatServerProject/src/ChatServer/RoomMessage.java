package ChatServer;

import java.util.ArrayList;

public class RoomMessage extends ChatMessage {

  public ArrayList roomArrayList;

  public void RoomMessage(AbstractUser sender, AbstractRoom room, String message) {
  }

  public void RoomMessage(AbstractUser sender, ArrayList<AbstractRoom> roomArrayList, String message) {
  }

}