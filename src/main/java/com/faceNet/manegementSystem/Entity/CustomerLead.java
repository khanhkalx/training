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
@Table(name = "CUSTOMER_LEAD")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerLead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    private String position;
    private String phone;
    private String email;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    private String note;
}
