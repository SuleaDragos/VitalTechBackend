package com.backend.VitalTech.controllers;

import com.backend.VitalTech.model.RecomandariDTO;
import com.backend.VitalTech.service.RecomandariService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/recomandari")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class RecomandariControllers {
    private final RecomandariService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecomandariDTO> addRecomandari(@RequestBody RecomandariDTO recomandariDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addRecomandari(recomandariDTO));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RecomandariDTO>> getRecomandarile(){
        return ResponseEntity.ok(service.getRecomandarile());
    }
    @GetMapping(value = "/pacientId={id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RecomandariDTO>> getRecomandarileByPacientId(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getRecomandarileByPacientId(id));
    }
    @GetMapping(value = "/id={id}")
    public ResponseEntity<RecomandariDTO> getRecomandariById(@PathVariable("id") Long id){
        try{
            RecomandariDTO e = service.getRecomandariById(id);
            return ResponseEntity.ok(service.getRecomandariById(id));
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/id={id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecomandari(@PathVariable("id") Long id){
        service.deleteRecomandari(id);
    }
}
