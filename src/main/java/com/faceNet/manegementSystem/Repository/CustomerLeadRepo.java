package com.faceNet.manegementSystem.Repository;

import com.faceNet.manegementSystem.Entity.CustomerLead;

public interface CustomerLeadRepo {
    Boolean findById(Long id);
    CustomerLead create(CustomerLead customerLead);
}
