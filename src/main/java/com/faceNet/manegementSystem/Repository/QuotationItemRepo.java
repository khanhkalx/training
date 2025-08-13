package com.faceNet.manegementSystem.Repository;

import com.faceNet.manegementSystem.Entity.QuotationItem;

import java.util.List;

/**
 * @author Leo Nguyen
 */
public interface QuotationItemRepo {
    List<QuotationItem> saveAll(List<QuotationItem> quotationItems);
}
