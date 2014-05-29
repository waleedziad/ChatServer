package ExceptionLayer;

public class UserNotFoundException extends Exception {

 String message ;
  public void setMessage(String msg) {
      message = msg ;
  }

  public String getMessage() {
  return "output message : "+message ;
  }

}