package com.faceNet.manegementSystem.Repository.jpa;

import com.faceNet.manegementSystem.Entity.ProductInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Leo Nguyen
 */
@Repository
public interface ProductInterestJpa extends JpaRepository<ProductInterest, Long> {
}
