package PersistanceLayer;

public class PersistanceFActory {

  public IPersistanceMechanism loadPersistanceMechanism(int choice) {
      if (choice == 1){System.out.print("F");return FilePersistance.getInstance();}
      return SQLPersistance.getInstance();
  }

}