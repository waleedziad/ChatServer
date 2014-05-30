package ChatServer;

public class ChatMessage {

  public AbstractUser sender;

  public String message;

  public void setSender(AbstractUser user) {
      sender = user ;
  }

  public AbstractUser getSender() {
  return sender ;
  }

  public void setMessage(String msg) {
      message = msg ;
  }

  public String  getMessage() {
      return message ;
  }
    @Override
  public String toString (){
        return "sender : " +sender.getName()+"  message : "+message+"";
  }
}