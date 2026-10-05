package com.mw.pub.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class ErrorsDto {
    @NotNull
    private String message;
    private String statusCode;
    private String statusMessage;



    public ErrorsDto(String message, String statusCode, String statusMessage) {
        this.message = message;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

}
