package com.example.bookmarket.domain.request;

import lombok.Data;

@Data
public class ReqPersonalCabinet {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long number;
}
