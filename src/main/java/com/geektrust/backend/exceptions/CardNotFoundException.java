package com.geektrust.backend.exceptions;

public class CardNotFoundException extends Exception{
    
    public CardNotFoundException()
    {
    }

    public CardNotFoundException(String msg)
    {
        super(msg);
    }
}
