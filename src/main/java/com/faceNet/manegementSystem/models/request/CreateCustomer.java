package com.faceNet.manegementSystem.models.request;

import com.faceNet.manegementSystem.Common.CommonEnum;
import com.faceNet.manegementSystem.models.respone.BadRequestException;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;


@Data
public class CreateCustomer {
    private EnterpriseRequest enterpriseRequest;
    private CustomerContactRq customerContactRq;
    private CustomerLeadRq customerLeadRq;

    public void validate() {
        if (StringUtils.isEmpty(this.enterpriseRequest.getBusinessName())) {
            throw new BadRequestException(CommonEnum.BUSINESS_NAME.getKey(),
                    CommonEnum.BUSINESS_NAME.getKey(),
                    CommonEnum.BUSINESS_NAME.getValue());
        }
        if (!customerContactRq.isValidPhoneNumber()) {
            throw new BadRequestException(CommonEnum.PHONE_NOT_NULL.getKey(),
                    CommonEnum.PHONE_NOT_NULL.getKey(),
                    CommonEnum.PHONE_NOT_NULL.getValue());
        }
        if (StringUtils.isEmpty(this.customerContactRq.getEmail())) {
            throw new BadRequestException(CommonEnum.EMAIL_NOT_NULL.getKey(),
                    CommonEnum.EMAIL_NOT_NULL.getKey(),
                    CommonEnum.EMAIL_NOT_NULL.getValue());
        }
        if (this.enterpriseRequest.getCustomerType() == null) {
            throw new BadRequestException(CommonEnum.CUSTOMER_TYPE_NOT_NULL.getKey(),
                    CommonEnum.CUSTOMER_TYPE_NOT_NULL.getKey(),
                    CommonEnum.CUSTOMER_TYPE_NOT_NULL.getValue());
        }
    }
}
