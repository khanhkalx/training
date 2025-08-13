package com.faceNet.manegementSystem.Repository.impl;

import com.faceNet.manegementSystem.Common.CommonEnum;
import com.faceNet.manegementSystem.Entity.CustomerEnterprise;
import com.faceNet.manegementSystem.Repository.CustomerEnterpriseRepo;
import com.faceNet.manegementSystem.Repository.jpa.CustomerContactJpa;
import com.faceNet.manegementSystem.Repository.jpa.CustomerEnterpriseJpa;
import com.faceNet.manegementSystem.Repository.jpa.CustomerLeadJpa;
import com.faceNet.manegementSystem.Repository.jpa.ProductInterestJpa;
import com.faceNet.manegementSystem.models.respone.BadRequestException;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leo Nguyen
 */
@Component
public class CustomerEnterpriseRepoImpl implements CustomerEnterpriseRepo {

    private final CustomerEnterpriseJpa customerEnterpriseJpa;


    public CustomerEnterpriseRepoImpl(CustomerEnterpriseJpa customerEnterpriseJpa, CustomerContactJpa customerContactJpa, CustomerLeadJpa customerLeadJpa, ProductInterestJpa productInterestJpa) {
        this.customerEnterpriseJpa = customerEnterpriseJpa;
    }

    @Override
    public Page<CustomerEnterprise> findAll(Pageable pageable) {
        Specification<CustomerEnterprise> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            return cb.and(predicates.toArray(new Predicate[0]));
        };

        return customerEnterpriseJpa.findAll(spec, pageable);
    }

    @Override
    public Boolean findById(Long id) {
        return customerEnterpriseJpa.findById(id).isPresent();
    }

    @Override
    public CustomerEnterprise selectById(Long id) {
        return customerEnterpriseJpa.findById(id).orElseThrow(() -> new BadRequestException(
                CommonEnum.NOT_FOUND.getKey(),
                CommonEnum.NOT_FOUND.getKey(),
                CommonEnum.NOT_FOUND.getValue()));
    }

    @Override
    public CustomerEnterprise create(CustomerEnterprise customerEnterprise) {
        return customerEnterpriseJpa.save(customerEnterprise);
    }

    @Override
    public List<CustomerEnterprise> getAllById(List<Long> ids) {
        return customerEnterpriseJpa.findAllById(ids);
    }

}
