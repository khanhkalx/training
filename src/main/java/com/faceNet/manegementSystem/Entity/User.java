package com.faceNet.manegementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Leo Nguyen
 */
@Data
@Table(name = "FACE_USER")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String userName;
    @Column(name = "full_name")
    private String fullName;
    private String position;
    private String brand;
}
