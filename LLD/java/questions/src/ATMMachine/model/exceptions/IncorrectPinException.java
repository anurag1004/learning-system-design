package ATMMachine.model.exceptions;

public class IncorrectPinException extends Exception{
    public IncorrectPinException(String msg){
        super(msg);
    }
}
