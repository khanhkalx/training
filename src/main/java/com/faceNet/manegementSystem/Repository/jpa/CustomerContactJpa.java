package com.faceNet.manegementSystem.Repository.jpa;

import com.faceNet.manegementSystem.Entity.CustomerContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerContactJpa extends JpaRepository<CustomerContact, Long> {
}
