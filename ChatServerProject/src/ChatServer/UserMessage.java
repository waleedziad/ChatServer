package ChatServer;

import java.util.ArrayList;

public class UserMessage extends ChatMessage {

  public ArrayList<AbstractUser> recipients;

  public void UserMessage(AbstractUser sender, AbstractUser recipient, String message) {
      send = sender ;
      recipients.add(recipient);
      this.message = message ;
  }

  public void UserMessage(AbstractUser sender, ArrayList<AbstractUser> recipientsList, String message) {
       send = sender ;
      recipients = recipientsList ;
      this.message = message ;
  }

}