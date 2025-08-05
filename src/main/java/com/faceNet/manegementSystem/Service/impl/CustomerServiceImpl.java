package com.faceNet.manegementSystem.Service.impl;

import com.faceNet.manegementSystem.Service.ICustomerService;
import com.faceNet.manegementSystem.models.respone.BaseResponse;
import com.faceNet.manegementSystem.models.respone.ResponseUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ResponseUtility responseEntity;


    public ResponseEntity<BaseResponse> getListCustomerEnterprise() {
        return responseEntity.successResponse("");
    }
}
