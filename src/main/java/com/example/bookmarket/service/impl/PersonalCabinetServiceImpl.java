package com.example.bookmarket.service.impl;

import com.example.bookmarket.domain.PersonalCabinet;
import com.example.bookmarket.domain.request.ReqPersonalCabinet;
import com.example.bookmarket.repository.PersonalCabinetRepository;
import com.example.bookmarket.service.PersonalCabinetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalCabinetServiceImpl implements PersonalCabinetService {
    private final PersonalCabinetRepository personalCabinetRepository;

    public PersonalCabinetServiceImpl(PersonalCabinetRepository personalCabinetRepository) {
        this.personalCabinetRepository = personalCabinetRepository;
    }

    public String create(ReqPersonalCabinet reqPersonalCabinet) {
        try {
            PersonalCabinet personalCabinet = new PersonalCabinet();
            personalCabinet.setFirstName(reqPersonalCabinet.getFirstName());
            personalCabinet.setLastName(reqPersonalCabinet.getLastName());
            personalCabinet.setEmail(reqPersonalCabinet.getEmail());
            personalCabinet.setNumber(reqPersonalCabinet.getNumber());
            personalCabinetRepository.save(personalCabinet);
            return "Save";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }

    public String update(ReqPersonalCabinet reqPersonalCabinet) {
        try {
            if (reqPersonalCabinet.getId() != null) {
                if (personalCabinetRepository.findById(reqPersonalCabinet.getId()).isPresent()) {
                    PersonalCabinet personalCabinet = new PersonalCabinet();
                    personalCabinet.setFirstName(reqPersonalCabinet.getFirstName());
                    personalCabinet.setLastName(reqPersonalCabinet.getLastName());
                    personalCabinet.setEmail(reqPersonalCabinet.getEmail());
                    personalCabinet.setNumber(reqPersonalCabinet.getNumber());
                    personalCabinetRepository.save(personalCabinet);
                    return "Save";
                } else {
                    return "id tanlanmadi";
                }
            } else {
                return "id topilmadi";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }

    public List<PersonalCabinet> all() {
        return personalCabinetRepository.findAll();
    }

    public PersonalCabinet byId(Long id) {
        Optional<PersonalCabinet> byId = personalCabinetRepository.findById(id);
        return byId.orElseGet(PersonalCabinet::new);
    }

    public void delete(Long id) {
        PersonalCabinet personalCabinet = personalCabinetRepository.getReferenceById(id);
        personalCabinetRepository.delete(personalCabinet);
    }

}
