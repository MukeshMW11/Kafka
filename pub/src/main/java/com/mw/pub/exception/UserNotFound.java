package com.mw.pub.exception;

public class UserNotFound extends RuntimeException{
 public UserNotFound(String message){
    super(message);
}
}
