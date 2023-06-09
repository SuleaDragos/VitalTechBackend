package com.backend.VitalTech.controllers;

import com.backend.VitalTech.model.AlarmeDTO;
import com.backend.VitalTech.model.PacientDTO;
import com.backend.VitalTech.service.AlarmeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/alarme")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class AlarmeControllers {
    private final AlarmeService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlarmeDTO> addAlarme(@RequestBody AlarmeDTO alarmeDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addAlarme(alarmeDTO));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AlarmeDTO>> getAlarmele(){
        return ResponseEntity.ok(service.getAlarmele());
    }
    @GetMapping(value = "/pacientId={id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AlarmeDTO>> getAlarmeleByPacientId(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getAlarmeleByPacientId(id));
    }
    @GetMapping(value = "/id={id}")
    public ResponseEntity<AlarmeDTO> getAlarmeById(@PathVariable("id") Long id){
        try{
            AlarmeDTO e = service.getAlarmeById(id);
            return ResponseEntity.ok(service.getAlarmeById(id));
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/id={id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlarme(@PathVariable("id") Long id){
        service.deleteAlarme(id);
    }
    @PutMapping(value = "/id={id}")
    public ResponseEntity<AlarmeDTO> updateAlarme(@PathVariable("id") Long id, @RequestBody AlarmeDTO alarmeDTO){
        return ResponseEntity.ok(service.updateAlarme(id,alarmeDTO));
    }
}
