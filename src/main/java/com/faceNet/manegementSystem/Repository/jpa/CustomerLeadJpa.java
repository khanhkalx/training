package com.faceNet.manegementSystem.Repository.jpa;

import com.faceNet.manegementSystem.Entity.CustomerLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerLeadJpa extends JpaRepository<CustomerLead, Long> {
}
