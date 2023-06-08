package com.backend.VitalTech.controllers;

import com.backend.VitalTech.model.PacientDTO;
import com.backend.VitalTech.service.PacientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/pacient")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class PacientControllers {
    private final PacientService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PacientDTO> addPacient(@RequestBody PacientDTO pacientDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addPacient(pacientDTO));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PacientDTO>> getPacienti(){
     return ResponseEntity.ok(service.getPacienti());
    }
    @GetMapping(value = "/medicId={id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PacientDTO>> getPacientiByMedicId(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getPacientiByMeidcId(id));
    }
    @GetMapping(value = "/id={id}")
    public ResponseEntity<PacientDTO> getPacientById(@PathVariable("id") Long id){
        try{
            PacientDTO e = service.getPacientById(id);
            return ResponseEntity.ok(service.getPacientById(id));
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/id={id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePacient(@PathVariable("id") Long id){
        service.deletePacient(id);
    }

    @PutMapping(value = "/id={id}")
    public ResponseEntity<PacientDTO> updatePacient(@PathVariable("id") Long id,@RequestBody PacientDTO pacientDTO){
        return ResponseEntity.ok(service.updatePacient(id,pacientDTO));
    }
    @GetMapping(value = "/mail={mail}/password={password}")
    public Long getPacientIdByEmail(@PathVariable("mail") String mail,
                                    @PathVariable("password") String password){
        return service.getPacientIdByEmail(mail,password);
    }
    @GetMapping(value = "/mobile/mail={mail}/password={password}")
    public ResponseEntity<PacientDTO> getPacientByEmailMobile(@PathVariable("mail") String mail,
                                                              @PathVariable("password") String password){
        try{
            PacientDTO e = service.getPacientByEmail(mail, password);
            return ResponseEntity.ok(service.getPacientByEmail(mail,password));
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
