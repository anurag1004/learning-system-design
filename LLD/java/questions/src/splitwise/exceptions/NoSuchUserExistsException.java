package splitwise.exceptions;

public class NoSuchUserExistsException extends Exception{
    public NoSuchUserExistsException(String msg){
        super(msg);
    }
}
