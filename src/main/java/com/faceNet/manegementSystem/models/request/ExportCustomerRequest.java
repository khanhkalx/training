package com.faceNet.manegementSystem.models.request;

import lombok.Data;

import java.util.List;

@Data
public class ExportCustomerRequest {
    private List<Long> ids;
}
