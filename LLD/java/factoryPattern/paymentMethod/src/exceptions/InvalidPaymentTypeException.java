package exceptions;

public class InvalidPaymentTypeException extends Exception{
    public InvalidPaymentTypeException(String msg){
        super(msg);
    }
}
