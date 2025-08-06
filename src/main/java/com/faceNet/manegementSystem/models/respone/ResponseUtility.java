package com.faceNet.manegementSystem.models.respone;

import com.faceNet.manegementSystem.Common.AppConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class ResponseUtility {

    private static final Logger logHelper = LogManager.getLogger(ResponseUtility.class);

    public ResponseEntity<BaseResponse> successResponse(Object data) {
        SuccessResponse successResponse = new SuccessResponse(data);
        logHelper.info(String.valueOf(successResponse));
        ResponseEntity<BaseResponse> res = ResponseEntity.status(HttpStatus.OK).body(successResponse);
        return res;
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BaseResponse> badRequestException(BadRequestException exception) {
        ErrorResponse errorResponse = new ErrorResponse(AppConstant.SYSTEM_BAD_REQUEST, exception.getMessage(), exception.getMessageKey(), exception.getCode());
        logHelper.info("Exception in class: " + exception.getStackTrace()[0].getClassName() + " response" + String.valueOf(errorResponse), exception);
        ResponseEntity<BaseResponse> res = ResponseEntity.status(HttpStatus.OK).body(errorResponse);
        return res;
    }
}
