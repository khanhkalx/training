package com.faceNet.manegementSystem.Service.impl;

import com.faceNet.manegementSystem.Common.CommonEnum;
import com.faceNet.manegementSystem.Entity.CustomerContact;
import com.faceNet.manegementSystem.Entity.CustomerEnterprise;
import com.faceNet.manegementSystem.Repository.*;
import com.faceNet.manegementSystem.Service.ICustomerService;
import com.faceNet.manegementSystem.models.Dto.CustomerDto;
import com.faceNet.manegementSystem.models.request.CreateCustomer;
import com.faceNet.manegementSystem.models.respone.BadRequestException;
import com.faceNet.manegementSystem.models.respone.BaseResponse;
import com.faceNet.manegementSystem.models.respone.PagedResponse;
import com.faceNet.manegementSystem.models.respone.ResponseUtility;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Leo Nguyen
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ResponseUtility responseEntity;
    @Autowired
    private CustomerContactRepo customerContactRepo;
    @Autowired
    private CustomerEnterpriseRepo customerEnterpriseRepo;
    @Autowired
    private CustomerLeadRepo customerLeadRepo;
    @Autowired
    private ProductInterestRepo productInterestRepo;
    @Autowired
    private UserRepo userRepo;

    @Override
    public ResponseEntity<BaseResponse> getListCustomerEnterprise(Integer pageNumber, Integer pageSize) {
        if (pageSize < 1 || pageSize > 1000) {
            throw new BadRequestException(CommonEnum.BAD_REQUEST.getKey(), CommonEnum.BAD_REQUEST.getKey(), CommonEnum.BAD_REQUEST.getValue());
        }
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<CustomerEnterprise> customerEnterprises = customerEnterpriseRepo.findAll(pageable);
        List<CustomerEnterprise> list = customerEnterprises.getContent();
        // Lấy toàn bộ contactId từ enterprises
        List<Long> contactIds = list.stream()
                .map(CustomerEnterprise::getCustomerContact)
                .filter(Objects::nonNull)
                .map(Integer::longValue)
                .distinct()
                .collect(Collectors.toList());

        // Map contactId -> CustomerContact
        Map<Long, CustomerContact> contactMap = customerContactRepo.findAllById(contactIds).stream()
                .collect(Collectors.toMap(CustomerContact::getId, Function.identity()));

        // Map sang CustomerDto
        List<CustomerDto> dtoList = list.stream()
                .map(ent -> {
                    Long contactId = ent.getCustomerContact() != null ? ent.getCustomerContact().longValue() : null;
                    CustomerContact contact = contactMap.get(contactId);
                    return new CustomerDto(ent, contact);
                })
                .collect(Collectors.toList());
        PagedResponse<CustomerDto> pagedResponse = new PagedResponse<>(
                dtoList,
                customerEnterprises.getTotalPages(),
                customerEnterprises.getTotalElements()
        );
        return responseEntity.successResponse(pagedResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> createCustomer(CreateCustomer customer) {
        customer.validate();
        CustomerContact contact = new CustomerContact(customer.getCustomerContactRq());
        Random random = new Random();
        String code = "CT" + String.format("%06d", random.nextInt(1_000_000));
        contact.setCode(code);
        customerContactRepo.create(contact);
        CustomerEnterprise enterprise = new CustomerEnterprise(customer.getEnterpriseRequest());
        enterprise.setCustomerContact(Math.toIntExact(contact.getId()));
        customerEnterpriseRepo.create(enterprise);
        return responseEntity.successResponse("");
    }

    @Override
    public ByteArrayInputStream exportCustomer(List<Long> ids) {
        List<CustomerEnterprise> enterprises = customerEnterpriseRepo.getAllById(ids);
        // get list contactId
        List<Long> contactIds = enterprises.stream()
                .map(CustomerEnterprise::getCustomerContact)
                .filter(Objects::nonNull)
                .map(Integer::longValue)
                .distinct()
                .collect(Collectors.toList());
        // get CustomerContact tương ứng
        Map<Long, CustomerContact> contactMap = customerContactRepo.findAllById(contactIds).stream()
                .collect(Collectors.toMap(CustomerContact::getId, Function.identity()));
        // Mapping sang DTO
        List<CustomerDto> dtoList = enterprises.stream()
                .map(ent -> {
                    Long contactId = ent.getCustomerContact() != null ? ent.getCustomerContact().longValue() : null;
                    CustomerContact contact = contactMap.get(contactId);
                    return new CustomerDto(ent, contact);
                })
                .toList();
        return writeToExcel(dtoList);
    }

    @Override
    public ResponseEntity<BaseResponse> getUser() {
        return responseEntity.successResponse(userRepo.getUser());
    }

    private ByteArrayInputStream writeToExcel(List<CustomerDto> customers) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("CustomerEnterprise");

            String[] headers = {"Tên doanh nghiệp", "Số điện thoại", "Email", "Tỉnh/TP", "Quận/Huyện", "Địa chỉ", "Nguồn"};
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            int rowIdx = 1;
            for (CustomerDto dto : customers) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(dto.getBusinessName());
                row.createCell(1).setCellValue(dto.getPhone());
                row.createCell(2).setCellValue(dto.getEmail());
                row.createCell(3).setCellValue(dto.getCity());
                row.createCell(4).setCellValue(dto.getDistrict());
                row.createCell(5).setCellValue(dto.getAddress());
                row.createCell(6).setCellValue(dto.getSource());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
