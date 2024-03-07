package ATMMachine.model.exceptions;

public class NoSuchCardExistException extends Exception{
    public NoSuchCardExistException(String msg){
        super(msg);
    }
}
