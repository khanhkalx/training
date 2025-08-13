package com.faceNet.manegementSystem.models.request;

import com.faceNet.manegementSystem.models.Dto.FeeDto;
import com.faceNet.manegementSystem.models.Dto.FileDto;
import com.faceNet.manegementSystem.models.Dto.ProductDto;
import com.faceNet.manegementSystem.models.Dto.QuotationRequestDto;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Leo Nguyen
 */
@Data
public class QuotationRequest {
    private QuotationRequestDto quotationRequestDto;
    private List<ProductDto> productDto;
    private FeeDto feeDto;
    private FileDto fileDto;
}
