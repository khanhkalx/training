package com.faceNet.manegementSystem.Entity;

import com.faceNet.manegementSystem.models.Dto.FileDto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Leo Nguyen
 */
@Entity
@Table(name = "quotation_attachment")
@Data
public class QuotationAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quotation_id")
    private Long quotationId;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_path")
    private String filePath;
    @Column(name = "file_type")
    private String fileType;
    @Column(name = "uploaded_by")
    private Long uploadedBy;
    @Column(name = "uploaded_date")
    private LocalDateTime uploadedDate = LocalDateTime.now();

    public QuotationAttachment(Long id, FileDto dto) {
        this.quotationId = id;
        this.fileName = dto.getFileName();
        this.filePath = dto.getFilePath();
    }
}

