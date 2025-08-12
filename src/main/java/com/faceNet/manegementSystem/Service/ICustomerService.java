package com.faceNet.manegementSystem.Service;

import com.faceNet.manegementSystem.Entity.CustomerEnterprise;
import com.faceNet.manegementSystem.models.request.CreateCustomer;
import com.faceNet.manegementSystem.models.respone.BaseResponse;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface ICustomerService {
    ResponseEntity<BaseResponse> getListCustomerEnterprise(Integer pageNumber, Integer pageSize);

    ResponseEntity<BaseResponse> createCustomer(CreateCustomer customer);

    ByteArrayInputStream exportCustomer(List<Long> ids);

    ResponseEntity<BaseResponse> getUser();
}
