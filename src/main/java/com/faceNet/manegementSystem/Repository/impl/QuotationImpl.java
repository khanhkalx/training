package com.faceNet.manegementSystem.Repository.impl;

import com.faceNet.manegementSystem.Common.CommonEnum;
import com.faceNet.manegementSystem.Entity.Quotation;
import com.faceNet.manegementSystem.Repository.QuotationRepo;
import com.faceNet.manegementSystem.Repository.jpa.QuotationJpa;
import com.faceNet.manegementSystem.models.request.QuotationRequest;
import com.faceNet.manegementSystem.models.respone.BadRequestException;
import com.faceNet.manegementSystem.models.respone.ErrorResponse;
import org.springframework.stereotype.Component;

/**
 * @author Leo Nguyen
 */
@Component
public class QuotationImpl implements QuotationRepo {
    private final QuotationJpa quotationJpa;

    public QuotationImpl(QuotationJpa quotationJpa) {
        this.quotationJpa = quotationJpa;
    }

    @Override
    public Quotation createQuotation(Quotation request) {
        return quotationJpa.save(request);
    }

    @Override
    public Quotation updateQuotation(Long id, Quotation request) {
        Quotation existingQuotation = quotationJpa.findById(id)
                .orElseThrow(() -> new BadRequestException(CommonEnum.NOT_FOUND.getKey(),
                        CommonEnum.NOT_FOUND.getKey(),
                        CommonEnum.NOT_FOUND.getValue()));
        existingQuotation.updateQuotation(request);
        return quotationJpa.save(existingQuotation);
    }

    @Override
    public void deleteQuotation(Long id) {
        quotationJpa.deleteById(id);
    }

    @Override
    public Quotation getQuotationById(Long id) {
        return quotationJpa.findById(id).get();
    }
}
