package com.faceNet.manegementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "QUOTATION_FEE_ITEM")
public class QuotationFeeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quotation_id")
    private Long quotationId;
    @Column(name = "fee_name")
    private String feeName;
    private String unit;
    private Double quantity;
    @Column(name = "unit_price")
    private Double unitPrice;
    @Column(name = "discount_percent")
    private Double discountPercent;
    @Column(name = "vat_percent")
    private Double vatPercent;
    @Column(name = "total_amount")
    private Double totalAmount;
}
