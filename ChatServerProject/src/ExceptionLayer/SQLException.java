package ExceptionLayer;

public class SQLException extends PersistanceException {
    
String message ;
  public void setMessage(String msg) {
      message = msg ;
  }

  public String getMessage() {
  return "output message : "+message ;
  }

}