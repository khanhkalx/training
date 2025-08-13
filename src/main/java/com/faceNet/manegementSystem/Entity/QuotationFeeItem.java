package com.faceNet.manegementSystem.Entity;

import com.faceNet.manegementSystem.models.Dto.FeeDto;
import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Leo Nguyen
 */
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
    private Integer quantity;
    @Column(name = "unit_price")
    private Double unitPrice;
    @Column(name = "discount_percent")
    private Double discountPercent;
    @Column(name = "vat_percent")
    private Double vatPercent;
    @Column(name = "total_amount")
    private Double totalAmount;

    public QuotationFeeItem(Long quotationId, FeeDto dto) {
        this.quotationId = quotationId;
        this.feeName = dto.getFeeName();
        this.unit = dto.getUnit();
        this.quantity = dto.getQuantity();
        this.unitPrice = dto.getPrice();
        this.discountPercent = dto.getDiscount();
        this.vatPercent = dto.getVat();
        this.totalAmount = dto.getAmount();
    }
}
