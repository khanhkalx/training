package com.faceNet.manegementSystem.models.Dto;

import lombok.Data;

/**
 * @author Leo Nguyen
 */
@Data
public class FeeDto {
    private String feeName;
    private String unit;
    private Integer quantity;
    private Double price;
    private Double discount;
    private Double vat;
    private Double amount;
}
