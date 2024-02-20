package ridesharingapp.model.exceptions;

public class NoSuchUserFoundException extends Exception{
    public NoSuchUserFoundException(String msg){
        super(msg);
    }
}
