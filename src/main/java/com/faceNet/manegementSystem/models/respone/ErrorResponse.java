package com.faceNet.manegementSystem.models.respone;

import com.faceNet.manegementSystem.Common.AppConstant;

public class ErrorResponse extends BaseResponse{

    public ErrorResponse(String message, String messageKey, String code) {
        super(AppConstant.SYSTEM_BAD_REQUEST, message, messageKey, code);
    }

    public ErrorResponse(String status, String message, String messageKey, Object data, String code) {
        super(status, message, messageKey, data, code);
    }

    public ErrorResponse(String status, String message, String messageKey, String code) {
        super(status, message, messageKey, code);
    }
}
