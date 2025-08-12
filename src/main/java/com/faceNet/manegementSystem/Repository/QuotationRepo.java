package com.faceNet.manegementSystem.Repository;

import com.faceNet.manegementSystem.Entity.Quotation;
import com.faceNet.manegementSystem.models.request.QuotationRequest;

/**
 * @author Leo Nguyen
 */
public interface QuotationRepo {
    Quotation createQuotation(Quotation request);

    Quotation updateQuotation(Long id, Quotation request);

    void deleteQuotation(Long id);

    Quotation getQuotationById(Long id);


}
