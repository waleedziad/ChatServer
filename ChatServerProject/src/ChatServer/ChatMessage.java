package ChatServer;

public class ChatMessage {

  public AbstractUser send;

  public String message;

  public void setSender(AbstractUser user) {
      send = user ;
  }

  public AbstractUser getSender() {
  return send ;
  }

  public void setMessage(String msg) {
      message = msg ;
  }

  public String  getMessage() {
      return message ;
  }

}