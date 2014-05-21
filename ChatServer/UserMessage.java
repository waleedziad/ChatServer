package ChatServer;

import String;

public class UserMessage extends ChatMessage {

  public List<IUser> recipients;

  public void UserMessage(IUser sender, IUser recipient, String message) {
  }

  public void UserMessage(IUser sender, List<IUser> recipientsList, String message) {
  }

}