package parkinglot.model.exceptions;

public class NoParkingSpotLeftException extends Exception{
    public NoParkingSpotLeftException(String msg){
        super(msg);
    }
}
