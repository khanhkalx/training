package com.faceNet.manegementSystem.Repository.impl;

import com.faceNet.manegementSystem.Entity.ProductInterest;
import com.faceNet.manegementSystem.Repository.ProductInterestRepo;
import com.faceNet.manegementSystem.Repository.jpa.ProductInterestJpa;
import org.springframework.stereotype.Component;

@Component
public class ProductInterestRepoImpl implements ProductInterestRepo {
    private final ProductInterestJpa productInterestJpa;

    public ProductInterestRepoImpl(ProductInterestJpa productInterestJpa) {
        this.productInterestJpa = productInterestJpa;
    }

    @Override
    public Boolean findById(Long id) {
        return productInterestJpa.findById(id).isPresent();
    }

    @Override
    public ProductInterest create(ProductInterest productInterest) {
        return productInterestJpa.save(productInterest);
    }
}
