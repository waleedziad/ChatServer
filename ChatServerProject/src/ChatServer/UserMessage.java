package ChatServer;

import java.util.ArrayList;

public class UserMessage extends ChatMessage {

  public ArrayList<AbstractUser> recipients;

  public void UserMessage(AbstractUser sender, AbstractUser recipient, String message) {
  }

  public void UserMessage(AbstractUser sender, ArrayList<AbstractUser> recipientsArrayList, String message) {
  }

}