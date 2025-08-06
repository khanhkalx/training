package com.faceNet.manegementSystem.Repository;

import com.faceNet.manegementSystem.Entity.ProductInterest;

public interface ProductInterestRepo {
    Boolean findById(Long id);
    ProductInterest create(ProductInterest productInterest);
}
