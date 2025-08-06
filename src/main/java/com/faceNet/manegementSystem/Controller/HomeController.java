package com.faceNet.manegementSystem.Controller;

import com.faceNet.manegementSystem.Entity.CustomerEnterprise;
import com.faceNet.manegementSystem.Service.ICustomerService;
import com.faceNet.manegementSystem.models.request.CreateCustomer;
import com.faceNet.manegementSystem.models.request.ExportCustomerRequest;
import com.faceNet.manegementSystem.models.respone.BaseResponse;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Validated
public class HomeController {

    private final ICustomerService customerService;

    public HomeController(ICustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/customerEnterprise")
    public ResponseEntity<?> getListCustomer(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
                                             @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        ResponseEntity<BaseResponse> res = customerService.getListCustomerEnterprise(pageNumber, pageSize);
        return res;
    }

    @PostMapping("/customerEnterprise")
    public ResponseEntity<?> createCustomer(@RequestBody CreateCustomer customer) {
        ResponseEntity<BaseResponse> res = customerService.createCustomer(customer);
        return res;
    }

    @GetMapping("/export")
    public ResponseEntity<?> exportExcel(@RequestBody ExportCustomerRequest request) throws IOException {
        List<Long> ids = request.getIds();
        ByteArrayInputStream inputStream = customerService.exportCustomer(ids);
        try {
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            String formattedDate = dateFormat.format(now);
            String fileName = "export" + formattedDate;
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(new InputStreamResource(inputStream));
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

}
