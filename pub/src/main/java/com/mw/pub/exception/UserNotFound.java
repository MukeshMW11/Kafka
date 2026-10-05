package com.mw.pub.exception;

public class UserNotFound extends RuntimeException{
 UserNotFound(String message){
    super(message);
}
}
