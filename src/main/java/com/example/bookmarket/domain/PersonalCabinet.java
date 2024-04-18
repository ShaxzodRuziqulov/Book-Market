package com.example.bookmarket.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "personal-cabinet")
public class PersonalCabinet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long number;
}
