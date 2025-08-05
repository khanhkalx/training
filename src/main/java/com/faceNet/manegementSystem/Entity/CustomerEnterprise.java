package com.faceNet.manegementSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "CUSTOMER_ENTERPRISE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEnterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "business_name")
    private String businessName;
    @Column(name = "founding_date")
    private Date foundingDate;
    private String field;
    @Column(name = "annual_revenue")
    private String annualRevenue;
    @Column(name = "employee_size")
    private String employeeSize;
    private String note;
    @Column(name = "attachment_path")
    private String attachmentPath;
    private Integer product;
    @Column(name = "customer_lead")
    private Integer customerLead;
    @Column(name = "customer_contact")
    private Integer customerContact;
    @Column(name = "customer_type")
    private Integer customerType;
    @Column(name = "assigned_staff")
    private Integer assignedStaff;
    private String source;

}

