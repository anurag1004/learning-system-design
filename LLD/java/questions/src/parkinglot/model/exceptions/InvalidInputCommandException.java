package parkinglot.model.exceptions;

import splitwise.exceptions.InvalidCommandException;

public class InvalidInputCommandException extends Exception{
    public InvalidInputCommandException(String msg){
        super(msg);
    }
}
