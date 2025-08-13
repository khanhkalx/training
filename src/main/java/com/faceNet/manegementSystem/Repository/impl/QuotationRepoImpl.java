package com.faceNet.manegementSystem.Repository.impl;

import com.faceNet.manegementSystem.Entity.QuotationItem;
import com.faceNet.manegementSystem.Repository.QuotationItemRepo;
import com.faceNet.manegementSystem.Repository.jpa.QuotationItemJpa;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Leo Nguyen
 */
@Component
public class QuotationRepoImpl implements QuotationItemRepo {
    private final QuotationItemJpa quotationItemJpa;

    public QuotationRepoImpl(QuotationItemJpa quotationItemJpa) {
        this.quotationItemJpa = quotationItemJpa;
    }

    @Override
    public List<QuotationItem> saveAll(List<QuotationItem> quotationItems) {
        return quotationItemJpa.saveAll(quotationItems);
    }
}
