package com.faceNet.manegementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "QUOTATION")
@Data
public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "contact_person_id")
    private Long contactPersonId;
    @Column(name = "quotation_code")
    private String quotationCode;
    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();
    @Column(name = "created_by")
    private Long createdBy;
    private String description;
    private String status;
}
