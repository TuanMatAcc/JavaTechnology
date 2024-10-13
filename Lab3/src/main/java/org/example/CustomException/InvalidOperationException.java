package org.example.CustomException;

public class InvalidOperationException extends Exception{
    public InvalidOperationException(String message) {
        super(message);
    }
}
