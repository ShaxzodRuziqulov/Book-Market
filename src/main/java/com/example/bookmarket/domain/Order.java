package com.example.bookmarket.domain;

import com.example.bookmarket.domain.enumation.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private PersonalCabinet personalCabinet;
    @ManyToOne
    private Products products;
    @CreationTimestamp
    private Timestamp createdAt;
    @Enumerated(EnumType.STRING)
    private Status status;
}