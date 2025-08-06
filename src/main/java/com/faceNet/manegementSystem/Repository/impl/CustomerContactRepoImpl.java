package com.faceNet.manegementSystem.Repository.impl;

import com.faceNet.manegementSystem.Entity.CustomerContact;
import com.faceNet.manegementSystem.Repository.CustomerContactRepo;
import com.faceNet.manegementSystem.Repository.jpa.CustomerContactJpa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerContactRepoImpl implements CustomerContactRepo {
    private final CustomerContactJpa customerContactJpa;

    public CustomerContactRepoImpl(CustomerContactJpa customerContactJpa) {
        this.customerContactJpa = customerContactJpa;
    }

    @Override
    public Boolean findById(Long id) {
        return customerContactJpa.findById(id).isPresent();
    }

    @Override
    public CustomerContact create(CustomerContact customerContact) {
        return customerContactJpa.save(customerContact);
    }

    @Override
    public List<CustomerContact> findAllById(List<Long> contactIds) {
        return customerContactJpa.findAllById(contactIds);
    }
}
