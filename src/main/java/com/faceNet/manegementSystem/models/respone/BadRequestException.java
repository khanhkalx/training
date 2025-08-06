package com.faceNet.manegementSystem.models.respone;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
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

}
