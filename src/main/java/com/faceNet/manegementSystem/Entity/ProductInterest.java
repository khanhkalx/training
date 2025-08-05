package com.faceNet.manegementSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "PRODUCT_INTEREST")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInterest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String productName;
    private String interestStatus;
    private Date interestStartDate;
    private String note;
}
