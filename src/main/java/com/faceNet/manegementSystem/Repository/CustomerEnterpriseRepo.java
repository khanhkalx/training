package com.faceNet.manegementSystem.Repository;

import com.faceNet.manegementSystem.Entity.CustomerEnterprise;

import java.util.List;

public interface CustomerEnterpriseRepo {
    List<CustomerEnterprise> findAll();
}
