package com.faceNet.manegementSystem.Entity;

import com.faceNet.manegementSystem.models.Dto.ProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Leo Nguyen
 */
@Entity
@Data
@Table(name = "QUOTATION_ITEM")
@NoArgsConstructor
public class QuotationItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quotation_id")
    private Long quotationId;
    @Column(name = "product_id")
    private Long productId;
    private Integer quantity;
    private Double unitPrice;
    private Double discountPercent;
    private Double discountAmount;
    private Double vatPercent;
    private Double vatAmount;
    private Double totalAmount;

    public QuotationItem(Long quotationId, ProductDto dto) {
        this.quotationId = quotationId;
        this.productId = dto.getProductId();
        this.quantity = dto.getQuantity();
        this.unitPrice = dto.getPrice();
        // Nếu discount trong ProductDto là % thì map vào discountPercent
        this.discountPercent = dto.getDiscount();
        // Nếu discount là số tiền thì map vào discountAmount
        // this.discountAmount = dto.getDiscount();
        // Nếu vat trong ProductDto là % thì map vào vatPercent
        this.vatPercent = dto.getVat();
        // Nếu vat là số tiền thì map vào vatAmount
        // this.vatAmount = dto.getVat();
        this.totalAmount = dto.getAmount();
    }

}
