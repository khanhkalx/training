package com.faceNet.manegementSystem.Service.impl;

import com.faceNet.manegementSystem.Repository.QuotationRepo;
import com.faceNet.manegementSystem.Service.IOperationService;
import com.faceNet.manegementSystem.models.Dto.QuotationRequestDto;
import com.faceNet.manegementSystem.models.respone.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Leo Nguyen
 */
@Service
public class IOperationServiceImpl implements IOperationService {

    @Autowired
    private QuotationRepo quotationRepo;

    @Override
    public ResponseEntity<BaseResponse> createQuotation(QuotationRequestDto request) {
        return null;
    }
}
