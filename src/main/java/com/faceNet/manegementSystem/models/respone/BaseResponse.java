package com.faceNet.manegementSystem.models.respone;

import com.faceNet.manegementSystem.Common.AppConstant;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseResponse implements Serializable {
    private String status;
    private Date timestamp = new Date();
    private String responseMessage;
    private Object data;
    private String responseCode;
    private String messageKey;

    public BaseResponse(Object data) {
        super();
        this.status = AppConstant.SYSTEM_OK;
        this.responseMessage = AppConstant.SUCCESS;
        this.data = data;
    }

    public BaseResponse(String status, String message, String messageKey) {
        this.status = status;
        this.responseMessage = message;
        this.messageKey = messageKey;
    }

    public BaseResponse(String status, String message, String messageKey, String code) {
        this.status = status;
        this.responseMessage = message;
        this.messageKey = messageKey;
        this.responseCode = code;
    }

    public BaseResponse(String status, String message, String messageKey, Object data) {
        this.status = status;
        this.responseMessage = message;
        this.messageKey = messageKey;
        this.data = data;
    }

    public BaseResponse(String status, String message, String messageKey, Object data, String code) {
        this.status = status;
        this.responseMessage = message;
        this.messageKey = messageKey;
        this.data = data;
        this.responseCode = code;
    }
}
