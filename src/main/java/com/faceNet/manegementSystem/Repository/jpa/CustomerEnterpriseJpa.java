package com.faceNet.manegementSystem.Repository.jpa;

import com.faceNet.manegementSystem.Entity.CustomerEnterprise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Leo Nguyen
 */
@Repository
public interface CustomerEnterpriseJpa extends JpaRepository<CustomerEnterprise, Long> {

    Page<CustomerEnterprise> findAll(Specification<CustomerEnterprise> spec, Pageable pageable);
}
