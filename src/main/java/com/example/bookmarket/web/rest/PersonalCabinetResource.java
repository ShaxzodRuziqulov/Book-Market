package com.example.bookmarket.web.rest;

import com.example.bookmarket.domain.PersonalCabinet;
import com.example.bookmarket.domain.request.ReqPersonalCabinet;
import com.example.bookmarket.service.PersonalCabinetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personal-cabinet")
public class PersonalCabinetResource {
    private final PersonalCabinetService personalCabinetService;

    public PersonalCabinetResource(PersonalCabinetService personalCabinetService) {
        this.personalCabinetService = personalCabinetService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ReqPersonalCabinet reqPersonalCabinet) {
        String config = personalCabinetService.create(reqPersonalCabinet);
        return ResponseEntity.ok(config);
    }
    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody ReqPersonalCabinet reqPersonalCabinet) {
        String config = personalCabinetService.update(reqPersonalCabinet);
        return ResponseEntity.ok(config);
    }
    @GetMapping("/all")
    public ResponseEntity<?> all(@RequestBody ReqPersonalCabinet reqPersonalCabinet) {
        List<PersonalCabinet> all = personalCabinetService.all();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/byId/{id}")
    public ResponseEntity<?> all(@PathVariable Long id) {
        PersonalCabinet findById = personalCabinetService.byId(id);
        return ResponseEntity.ok(findById);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        PersonalCabinet findById = personalCabinetService.byId(id);
        return ResponseEntity.ok(findById);
    }
}
