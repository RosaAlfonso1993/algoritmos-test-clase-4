package com.example.clase4.exceptions;

public class ContactError extends RuntimeException{
    public ContactError(String message) {
        super(buildMessage(message));
    }

    private static String buildMessage(String message){
        return message;
    }
}
