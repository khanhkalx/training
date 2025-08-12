package com.faceNet.manegementSystem.Service;

import com.faceNet.manegementSystem.models.Dto.QuotationRequestDto;
import com.faceNet.manegementSystem.models.respone.BaseResponse;
import org.springframework.http.ResponseEntity;

/**
 * @author Leo Nguyen
 */
public interface IOperationService {
    ResponseEntity<BaseResponse> createQuotation(QuotationRequestDto request);
}
