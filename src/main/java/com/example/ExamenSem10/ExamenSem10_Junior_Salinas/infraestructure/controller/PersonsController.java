package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.controller;


import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.application.service.PersonsService;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model.Persons;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonsController {
    private final PersonsService personsService;

    public PersonsController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @GetMapping()
    public ResponseEntity<List<Persons>> getPersons(){
        if (!personsService.buscarTodos().isEmpty()){
            return new ResponseEntity<>(personsService.buscarTodos(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<Persons> createPersons(@RequestBody Persons persons){
        Persons createPersons=personsService.guardar(persons);
        return new ResponseEntity<>(createPersons, HttpStatus.CREATED);
    }
    @GetMapping("/{personsId}")
    public ResponseEntity<Persons> getPersonsById(@PathVariable Long personsId){
        return personsService.busPorId(personsId).map(persons -> new ResponseEntity<>(persons,HttpStatus.OK) ).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping
    public ResponseEntity<Persons> updatePersons(@RequestBody Persons persons){
        Persons actualizarPersons=personsService.actualizar(persons);
        return new ResponseEntity<>(actualizarPersons, HttpStatus.CREATED);
    }
    @DeleteMapping("/{personsId}")
    public ResponseEntity<String> deletePersons(@PathVariable Long personsId){
        personsService.eliminar(personsId);
        return new ResponseEntity<>("Person deleted", HttpStatus.ACCEPTED);

    }
}
