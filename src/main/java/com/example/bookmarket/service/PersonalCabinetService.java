package com.example.bookmarket.service;

import com.example.bookmarket.domain.PersonalCabinet;
import com.example.bookmarket.domain.request.ReqPersonalCabinet;

import java.util.List;
import java.util.Optional;

public interface PersonalCabinetService {
    String create(ReqPersonalCabinet reqPersonalCabinet);

    String update(ReqPersonalCabinet reqPersonalCabinet);

    List<PersonalCabinet> all();

    PersonalCabinet byId(Long id);

    void delete(Long id);
}
