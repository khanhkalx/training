package com.faceNet.manegementSystem.Repository.impl;

import com.faceNet.manegementSystem.Entity.CustomerLead;
import com.faceNet.manegementSystem.Repository.CustomerLeadRepo;
import com.faceNet.manegementSystem.Repository.jpa.CustomerLeadJpa;
import org.springframework.stereotype.Component;

@Component
public class CustomerLeadRepoImpl implements CustomerLeadRepo {
    private final CustomerLeadJpa customerLeadJpa;

    public CustomerLeadRepoImpl(CustomerLeadJpa customerLeadJpa) {
        this.customerLeadJpa = customerLeadJpa;
    }

    @Override
    public Boolean findById(Long id) {
        return customerLeadJpa.findById(id).isPresent();
    }

    @Override
    public CustomerLead create(CustomerLead customerLead) {
        return customerLeadJpa.save(customerLead);
    }
}
