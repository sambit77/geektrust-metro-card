package com.geektrust.backend.exceptions;

public class InvalidPassengerTypeException extends Exception{
    public InvalidPassengerTypeException(){}

    public InvalidPassengerTypeException(String msg)
    {
        super(msg);
    }
    
}
