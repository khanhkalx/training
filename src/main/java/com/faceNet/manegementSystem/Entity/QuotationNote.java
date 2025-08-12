package com.faceNet.manegementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Leo Nguyen
 */
@Entity
@Table(name = "quotation_note")
@Data
public class QuotationNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quotation_id")
    private Long quotationId;
    @Column(name = "note_content")
    private String noteContent;
    @Column(name = "created_by")
    private Long createdBy;
    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

}

