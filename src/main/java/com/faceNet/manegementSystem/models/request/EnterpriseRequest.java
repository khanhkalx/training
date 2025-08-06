package com.faceNet.manegementSystem.models.request;


import lombok.Data;


@Data
public class EnterpriseRequest {
    private String businessName;
    private String foundingDate;
    private String field;
    private String annualRevenue;
    private Integer employeeSize;
    private String note;
    private String attachmentPath;
    private String category;
    private String productName;
    private String interestStatus;
    private String interestStartDate;
    private String noteProduct;
    private Integer customerType;
    private Integer assignedStaff;
    private String source;

}
