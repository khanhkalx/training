package com.faceNet.manegementSystem.Entity;

import com.faceNet.manegementSystem.models.request.CustomerContactRq;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CUSTOMER_CONTACT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phone;
    private String email;
    private String website;
    private String city;
    private String district;
    private String address;
    private String code;

    public CustomerContact(CustomerContactRq customerContactRq) {
        this.phone = customerContactRq.getPhone();
        this.email = customerContactRq.getEmail();
        this.website = customerContactRq.getWebsite();
        this.city = customerContactRq.getCity();
        this.district = customerContactRq.getDistrict();
        this.address = customerContactRq.getAddress();
    }
}
