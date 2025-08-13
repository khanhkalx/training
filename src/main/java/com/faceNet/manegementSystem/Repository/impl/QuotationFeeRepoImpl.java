package com.faceNet.manegementSystem.Repository.impl;

import com.faceNet.manegementSystem.Entity.QuotationFeeItem;
import com.faceNet.manegementSystem.Repository.QuotationFeeRepo;
import com.faceNet.manegementSystem.Repository.jpa.QuotationFeeJpa;
import org.springframework.stereotype.Component;

/**
 * @author Leo Nguyen
 */
@Component
public class QuotationFeeRepoImpl implements QuotationFeeRepo {
    private final QuotationFeeJpa quotationFeeJpa;

    public QuotationFeeRepoImpl(QuotationFeeJpa quotationFeeJpa) {
        this.quotationFeeJpa = quotationFeeJpa;
    }

    @Override
    public void save(QuotationFeeItem fee) {
        quotationFeeJpa.save(fee);
    }
}
