package com.example.bookmarket.domain.request;
import lombok.Data;
@Data
public class ReqOrder {
    private Long id;
    private Long personalCabinet;
    private Long products;
    private String status;
}
