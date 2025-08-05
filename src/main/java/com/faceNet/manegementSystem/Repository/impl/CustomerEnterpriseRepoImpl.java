package com.faceNet.manegementSystem.Repository.impl;

import com.faceNet.manegementSystem.Entity.CustomerEnterprise;
import com.faceNet.manegementSystem.Repository.CustomerEnterpriseRepo;
import com.faceNet.manegementSystem.Repository.jpa.CustomerEnterpriseJpa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerEnterpriseRepoImpl implements CustomerEnterpriseRepo {

    private final CustomerEnterpriseJpa customerEnterpriseJpa;

    public CustomerEnterpriseRepoImpl(CustomerEnterpriseJpa customerEnterpriseJpa) {
        this.customerEnterpriseJpa = customerEnterpriseJpa;
    }

    @Override
    public List<CustomerEnterprise> findAll() {
        return customerEnterpriseJpa.findAll();
    }
}
