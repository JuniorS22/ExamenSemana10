package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.controller;

import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.application.service.UsersService;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model.Persons;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model.Users;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }


    @GetMapping()
    public ResponseEntity<List<Users>> getUsers(){
        if (!usersService.buscarTodos().isEmpty()){
            return new ResponseEntity<>(usersService.buscarTodos(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<Users> createUsers(@RequestBody Users users){
        Users createUsers=usersService.guardar(users);
        return new ResponseEntity<>(createUsers, HttpStatus.CREATED);
    }
    @GetMapping("/{usersId}")
    public ResponseEntity<Users> getUsersById(@PathVariable Long usersId){
        return usersService.busPorId(usersId).map(users -> new ResponseEntity<>(users,HttpStatus.OK) ).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping
    public ResponseEntity<Users> updateUsers(@RequestBody Users users){
        Users actualizarUsers=usersService.actualizar(users);
        return new ResponseEntity<>(actualizarUsers, HttpStatus.CREATED);
    }
    @DeleteMapping("/{usersId}")
    public ResponseEntity<String> deletePersons(@PathVariable Long usersId){
        usersService.eliminar(usersId);
        return new ResponseEntity<>("Usuario eliminado con exito", HttpStatus.OK);
    }
}
