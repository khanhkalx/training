package com.faceNet.manegementSystem.models.Dto;

import com.faceNet.manegementSystem.Entity.CustomerContact;
import com.faceNet.manegementSystem.Entity.CustomerEnterprise;
import lombok.Data;

@Data
public class CustomerDto {
    private Long id;
    private String code;
    private String businessName;
    private String phone;
    private String email;
    private String city;
    private String district;
    private String address;
    private String source;

    public CustomerDto(CustomerEnterprise enterprise, CustomerContact customerContact) {
        this.id = enterprise.getId();
        this.code = customerContact != null && customerContact.getCode() != null ? customerContact.getCode() : "";
        this.businessName = enterprise != null && enterprise.getBusinessName() != null ? enterprise.getBusinessName() : "";
        this.source = enterprise != null && enterprise.getSource() != null ? enterprise.getSource() : "";
        this.phone = customerContact != null && customerContact.getPhone() != null ? customerContact.getPhone() : "";
        this.email = customerContact != null && customerContact.getEmail() != null ? customerContact.getEmail() : "";
        this.city = customerContact != null && customerContact.getCity() != null ? customerContact.getCity() : "";
        this.district = customerContact != null && customerContact.getDistrict() != null ? customerContact.getDistrict() : "";
        this.address = customerContact != null && customerContact.getAddress() != null ? customerContact.getAddress() : "";
    }

}
