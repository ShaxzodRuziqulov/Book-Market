package com.example.bookmarket.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookName;
    private String cost;
    private String author;
    private String cover;
    private String publisher;
    private String bookLanguage;
    private String page;
    private Long year;
}
