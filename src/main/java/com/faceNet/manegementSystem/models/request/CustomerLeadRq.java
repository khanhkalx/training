package com.faceNet.manegementSystem.models.request;


import lombok.Data;

@Data
public class CustomerLeadRq {
    private String fullName;
    private String position;
    private String phoneCustomerLead;
    private String emailCustomerLead;
    private String dateOfBirthCustomerLead;
    private String noteCustomerLead;
}
