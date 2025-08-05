package com.faceNet.manegementSystem.models.respone;


public class BadRequestException extends RuntimeException {

    private String message;
    private String messageKey;
    private String code;
    private Object data;

    public BadRequestException(String message, String messageKey, String code) {
        this.message = message;
        this.messageKey = messageKey;
        this.code = code;
    }

    public BadRequestException(String message, String messageKey, Object data, String code) {
        this.message = message;
        this.messageKey = messageKey;
        this.code = code;
        this.data = data;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
