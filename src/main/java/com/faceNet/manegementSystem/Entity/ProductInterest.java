package com.faceNet.manegementSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Leo Nguyen
 */
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
    @Column(name = "product_name")
    private String productName;
    @Column(name = "interest_status")
    private String interestStatus;
    @Column(name = "interest_start_date")
    private Date interestStartDate;
    private String note;
}
