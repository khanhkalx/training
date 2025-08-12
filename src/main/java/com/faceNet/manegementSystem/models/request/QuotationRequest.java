package com.faceNet.manegementSystem.models.request;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Leo Nguyen
 */
@Data
public class QuotationRequest {
    private Long customerId;
    private Long contactPersonId;
    private String quotationCode;
    private LocalDateTime createdDate = LocalDateTime.now();
    private Long createdBy;
    private String description;
    private String status;
}
