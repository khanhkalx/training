package com.faceNet.manegementSystem.models.Dto;


import lombok.Data;

import java.time.LocalDateTime;


/**
 * @author Leo Nguyen
 */
@Data
public class QuotationRequestDto {
    private Long customerLead;
    private Long customerEnterprise;
    private String quotationCode;
    private Long createdBy;
    private String description;
    private LocalDateTime createdDate = LocalDateTime.now();

}
