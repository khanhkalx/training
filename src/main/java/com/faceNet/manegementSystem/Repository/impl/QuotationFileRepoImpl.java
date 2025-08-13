package com.faceNet.manegementSystem.Repository.impl;

import com.faceNet.manegementSystem.Entity.QuotationAttachment;
import com.faceNet.manegementSystem.Repository.QuotationFileRepo;
import com.faceNet.manegementSystem.Repository.jpa.QuotationFileJpa;
import org.springframework.stereotype.Component;

/**
 * @author Leo Nguyen
 */
@Component
public class QuotationFileRepoImpl implements QuotationFileRepo {
    private final QuotationFileJpa quotationFileJpa;

    public QuotationFileRepoImpl(QuotationFileJpa quotationFileJpa) {
        this.quotationFileJpa = quotationFileJpa;
    }

    @Override
    public void save(QuotationAttachment quotationAttachment) {
        quotationFileJpa.save(quotationAttachment);
    }
}
