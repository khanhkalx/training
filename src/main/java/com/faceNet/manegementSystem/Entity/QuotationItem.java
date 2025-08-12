package com.faceNet.manegementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Leo Nguyen
 */
@Entity
@Data
@Table(name = "QUOTATION_ITEM")
public class QuotationItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quotation_id", nullable = false)
    private Long quotationId;
    @Column(name = "product_id")
    private Long productId;
    private Double quantity;
    private Double unitPrice;
    private Double discountPercent;
    private Double discountAmount;
    private Double vatPercent;
    private Double vatAmount;
    private Double totalAmount;
}
