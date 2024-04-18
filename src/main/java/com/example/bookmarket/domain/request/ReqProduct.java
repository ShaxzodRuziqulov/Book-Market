package com.example.bookmarket.domain.request;

import lombok.Data;

@Data
public class ReqProduct {
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
