package com.faceNet.manegementSystem.Repository.jpa;

import com.faceNet.manegementSystem.Entity.CustomerEnterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerEnterpriseJpa extends JpaRepository<CustomerEnterprise, Long> {

}
