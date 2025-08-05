package com.faceNet.manegementSystem.Service;

import com.faceNet.manegementSystem.models.respone.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface ICustomerService {
    ResponseEntity<BaseResponse> getListCustomerEnterprise();
}
