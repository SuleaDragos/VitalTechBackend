package com.backend.VitalTech.controllers;

import com.backend.VitalTech.model.DateMasurateDTO;
import com.backend.VitalTech.service.DateMasurateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/dateMasurate")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class DateMasurateControllers {
    private final DateMasurateService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DateMasurateDTO> addDateMasurate(@RequestBody DateMasurateDTO dateMasurateDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addDateMasurate(dateMasurateDTO));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DateMasurateDTO>> getDateMasuratele(){
        return ResponseEntity.ok(service.getDateMasuratele());
    }
    @GetMapping(value = "/pacientId={id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DateMasurateDTO>> getDateMasurateleByPacientId(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getDateMasurateleByPacientId(id));
    }
    @GetMapping(value = "/id={id}")
    public ResponseEntity<DateMasurateDTO> getDateMasurateById(@PathVariable("id") Long id){
        try{
            DateMasurateDTO e = service.getDateMasurateById(id);
            return ResponseEntity.ok(service.getDateMasurateById(id));
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/id={id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDateMasurate(@PathVariable("id") Long id){
        service.deleteDateMasurate(id);
    }
}
