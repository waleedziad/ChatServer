package ChatServer;

import java.util.ArrayList;

public class AbstractRoom {

  public String title;

  public String desciption;

  public ArrayList<AbstractUser> users;

  public int id;

  public void setTitle(String title) {
      this.title = title ;
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

  public ArrayList getUsers() {
  return users;
  }

  public void setID(int roomId) {
      id = roomId ;
  }

  public int getID() {
  return id ;
  }

}