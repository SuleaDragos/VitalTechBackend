package com.backend.VitalTech.controllers;

import com.backend.VitalTech.model.MedicDTO;
import com.backend.VitalTech.service.MedicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/medic")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class MedicControllers {
    private final MedicService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MedicDTO> addMedic(@RequestBody MedicDTO medicDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addMedic(medicDTO));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MedicDTO>> getMedici(){
        return ResponseEntity.ok(service.getMedici());
    }

    @GetMapping(value = "/id={id}")
    public ResponseEntity<MedicDTO> getMedicById(@PathVariable("id") Long id){
        try{
            MedicDTO e = service.getMedicById(id);
            return ResponseEntity.ok(service.getMedicById(id));
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/id={id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMedic(@PathVariable("id") Long id){
        service.deleteMedic(id);
    }
    @GetMapping(value = "/mail={mail}/password={password}")
    public Long getMedicIdByEmail(@PathVariable("mail") String mail,
                                  @PathVariable("password") String password){
        return service.getMedicIdByEmail(mail,password);
    }

    @GetMapping(value = "/mobile/mail={mail}/password={password}")
    public ResponseEntity<MedicDTO> getMedicIdByEmailMobile(@PathVariable("mail") String mail,
                                                            @PathVariable("password") String password){
        try{
            MedicDTO e = service.getMedicByEmail(mail,password);
            return ResponseEntity.ok(service.getMedicByEmail(mail,password));
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
