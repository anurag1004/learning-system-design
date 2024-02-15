package parkinglot.model.exceptions;

public class NoSuchSlotExistsException extends Exception{
    public NoSuchSlotExistsException(String msg){
        super(msg);
    }
}
