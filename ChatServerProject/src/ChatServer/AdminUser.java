package ChatServer;

import java.util.ArrayList;

public class AdminUser extends AbstractUser {

  public ArrayList permissions;

  public void addPermission(String permission) {
      permissions.add(permission);
  }

  public ArrayList<String> getPermissions() {
  return permissions;
  }

}