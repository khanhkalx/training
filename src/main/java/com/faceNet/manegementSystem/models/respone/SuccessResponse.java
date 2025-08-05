package com.faceNet.manegementSystem.models.respone;

public class SuccessResponse extends BaseResponse{
    public SuccessResponse(Object data) {
        super(data);
    }

    public SuccessResponse(String message, String messageKey, Object data) {
        super("200", message, messageKey, data);
    }

}
