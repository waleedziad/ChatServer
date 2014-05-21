package ChatServer;

public class AbstractUser {

  public int id;

  public String name;

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

}