package com.example.bookmarket.repository;

import com.example.bookmarket.domain.PersonalCabinet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalCabinetRepository extends JpaRepository<PersonalCabinet,Long> {

}
