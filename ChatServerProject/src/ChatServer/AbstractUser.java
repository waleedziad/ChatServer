package ChatServer;

import java.util.ArrayList;

public class AbstractUser {

  public int id;
  
  public String name;
  
  public ArrayList<ChatMessage> Messages ;

   public AbstractUser ()
   {
       Messages=new ArrayList<ChatMessage>() ;
   }
  public void setID(int userID) {
      id = userID ;
  }

  public int getID() {
  return id;
  }

  public void setName(String userName) {
      name = userName ;
  }

  public String getName() {
  return name;
  }
    @Override
public String toString()
{
    return "name : "+name+" id : "+ id ;
}
}