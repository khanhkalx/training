package com.faceNet.manegementSystem.Repository;

import com.faceNet.manegementSystem.Entity.QuotationAttachment;

/**
 * @author Leo Nguyen
 */
public interface QuotationFileRepo {
    void save(QuotationAttachment quotationAttachment);
}
