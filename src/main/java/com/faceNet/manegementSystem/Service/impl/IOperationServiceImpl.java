package com.faceNet.manegementSystem.Service.impl;

import com.faceNet.manegementSystem.Common.CommonEnum;
import com.faceNet.manegementSystem.Entity.*;
import com.faceNet.manegementSystem.Repository.*;
import com.faceNet.manegementSystem.Service.IOperationService;
import com.faceNet.manegementSystem.models.request.QuotationRequest;
import com.faceNet.manegementSystem.models.respone.BadRequestException;
import com.faceNet.manegementSystem.models.respone.BaseResponse;
import com.faceNet.manegementSystem.models.respone.ResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Leo Nguyen
 */
@Service
public class IOperationServiceImpl implements IOperationService {

    @Autowired
    private QuotationRepo quotationRepo;
    @Autowired
    private CustomerEnterpriseRepo customerEnterpriseRepo;
    @Autowired
    private QuotationItemRepo quotationItemRepo;
    @Autowired
    private QuotationFeeRepo quotationFeeRepo;
    @Autowired
    private ResponseUtility responseEntity;
    @Autowired
    private QuotationFileRepo quotationFileRepo;

    @Override
    public ResponseEntity<BaseResponse> createQuotation(QuotationRequest request) {
        CustomerEnterprise enterprise = customerEnterpriseRepo.selectById(request.getQuotationRequestDto().getCustomerEnterprise());
        if (enterprise == null) {
            throw new BadRequestException(CommonEnum.NOT_FOUND.getKey(), CommonEnum.NOT_FOUND.getKey(), CommonEnum.NOT_FOUND.getValue());
        }
        // save thong tin bao gia
        Quotation quotation = new Quotation(request.getQuotationRequestDto());
        quotationRepo.createQuotation(quotation);
        // save list product
        if (request.getProductDto() != null && !request.getProductDto().isEmpty()) {
            List<QuotationItem> quotationItems = request.getProductDto().stream()
                    .map(p -> new QuotationItem(quotation.getId(), p))
                    .toList();
            quotationItemRepo.saveAll(quotationItems);
        }
        // 4. Lưu phí phát sinh nếu có
        if (request.getFeeDto() != null) {
            QuotationFeeItem fee = new QuotationFeeItem(
                    quotation.getId(),
                    request.getFeeDto()
            );
            quotationFeeRepo.save(fee);
        }
        if (request.getFileDto() != null) {
            QuotationAttachment file = new QuotationAttachment(
                    quotation.getId(),
                    request.getFileDto()
            );
            quotationFileRepo.save(file);
        }
        return responseEntity.successResponse("");
    }
}
