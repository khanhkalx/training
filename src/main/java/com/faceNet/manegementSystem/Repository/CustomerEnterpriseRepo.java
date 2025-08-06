package com.faceNet.manegementSystem.Repository;

import com.faceNet.manegementSystem.Entity.CustomerEnterprise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerEnterpriseRepo {
    Page<CustomerEnterprise> findAll(Pageable pageable);

    Boolean findById(Long id);

    CustomerEnterprise create(CustomerEnterprise customerEnterprise);

    List<CustomerEnterprise> getAllById(List<Long> ids);
}
