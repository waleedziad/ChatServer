package PersistanceLayer;

public class PersistanceFActory {

  public IPersistanceMechanism loadPersistanceMechanism(int choice) {
      if (choice == 1)return SQLPersistance.getInstance();
      return FilePersistance.getInstance();
  }

}