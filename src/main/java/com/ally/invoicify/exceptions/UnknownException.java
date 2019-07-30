package com.ally.invoicify.exceptions;


public class UnknownException extends RuntimeException{
    public UnknownException(String message){
        super(message);
    }
}