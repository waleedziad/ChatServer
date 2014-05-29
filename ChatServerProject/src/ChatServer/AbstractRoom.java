package ChatServer;

import java.util.ArrayList;

public class AbstractRoom {

  public String title;

  public String desciption;

  public ArrayList<AbstractUser> users = new ArrayList<AbstractUser>();

  public int id;

  public void setTitle(String title) {
      this.title = title ;
  }
    @Override
public String toString()
{
    return "title : "+title+" users : "+users.toString() +"id : "+id ; 
}
  public String getTitle() {
  return title;
  }

  public void setDecription(String desc) {
      desciption = desc ;
  }

  public String getDesciption() {
  return desciption;
  }

  public ArrayList<AbstractUser> getUsers() {
      return users;
  }

  public void setID(int roomId) {
      id = roomId ;
  }

  public int getID() {
  return id ;
  }

}