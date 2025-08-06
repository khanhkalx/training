package com.faceNet.manegementSystem.Repository;


import com.faceNet.manegementSystem.Entity.CustomerContact;

import java.util.List;

public interface CustomerContactRepo {
    Boolean findById(Long id);
    CustomerContact create(CustomerContact customerContact);

    List<CustomerContact> findAllById(List<Long> contactIds);
}
