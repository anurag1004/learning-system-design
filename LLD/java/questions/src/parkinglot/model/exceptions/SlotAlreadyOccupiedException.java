package parkinglot.model.exceptions;

public class SlotAlreadyOccupiedException extends Exception{
    public SlotAlreadyOccupiedException(String msg){
        super(msg);
    }
}
