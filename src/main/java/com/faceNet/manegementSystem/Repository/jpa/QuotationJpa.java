package com.faceNet.manegementSystem.Repository.jpa;

import com.faceNet.manegementSystem.Entity.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Leo Nguyen
 */
@Repository
public interface QuotationJpa extends JpaRepository<Quotation, Long> {
}
