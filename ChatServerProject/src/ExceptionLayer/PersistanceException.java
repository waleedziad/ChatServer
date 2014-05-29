package ExceptionLayer;

public class PersistanceException extends Exception {
  String message ;
  public void setMessage(String msg) {
      message = msg ;
  }

  public String getMessage() {
  return "output message : "+message ;
  }

}