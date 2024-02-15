package parkinglot.model.exceptions;

public class UnableToParseTicketStringException extends Exception{
    public UnableToParseTicketStringException(String msg){
        super(msg);
    }
}
