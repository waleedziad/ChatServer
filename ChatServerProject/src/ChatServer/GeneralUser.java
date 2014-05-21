package ChatServer;

import java.util.ArrayList;

public class GeneralUser extends AbstractUser {

  public ArrayList<AbstractUser> blockedUser;

  public void addBlockedUser(AbstractUser User) {
      blockedUser.add(User);
  }

  public ArrayList getBlockedUsers() {
  return blockedUser;
  }

}