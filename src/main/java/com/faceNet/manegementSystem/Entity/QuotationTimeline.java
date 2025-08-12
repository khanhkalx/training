package com.faceNet.manegementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author Leo Nguyen
 */
@Entity
@Table(name = "QUOTATION_TIMELINE")
@Data
public class QuotationTimeline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quotation_id")
    private Long quotationId;
    @Column(name = "timeline_description")
    private String timelineDescription;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;

}

