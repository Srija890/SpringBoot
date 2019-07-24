package com.stackroute.Exceptions;

public class TrackNotFoundExceptions extends Exception{

    private String  exceptionmessage;
    public TrackNotFoundExceptions(String message)
    {
        super(message);
        this.exceptionmessage=message;
    }

}
