package com.faceNet.manegementSystem.Repository.jpa;

import com.faceNet.manegementSystem.Entity.QuotationAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Leo Nguyen
 */
@Repository
public interface QuotationFileJpa extends JpaRepository<QuotationAttachment, Long> {
}
