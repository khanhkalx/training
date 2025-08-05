package com.faceNet.manegementSystem.Controller;

import com.faceNet.manegementSystem.Service.ICustomerService;
import com.faceNet.manegementSystem.models.respone.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Validated
public class HomeController {

    private final ICustomerService customerService;

    public HomeController(ICustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/customerEnterprise")
    public ResponseEntity<?> getListCustomer() {
        ResponseEntity<BaseResponse> res = customerService.getListCustomerEnterprise();
        return res;
    }

}
