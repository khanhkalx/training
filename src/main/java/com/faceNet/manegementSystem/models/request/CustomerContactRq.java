package com.faceNet.manegementSystem.models.request;


import lombok.Data;

@Data
public class CustomerContactRq {
    private String phone;
    private String email;
    private String website;
    private String city;
    private String district;
    private String address;

    public boolean isValidPhoneNumber() {
        if (this.phone == null || this.phone.isEmpty()) {
            return true;
        }
        return this.phone.matches("^0\\d{9}$") && this.phone.length() == 10;
    }
}
