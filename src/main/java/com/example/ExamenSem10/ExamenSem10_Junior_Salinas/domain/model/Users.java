package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model;

import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.entity.PersonsEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.util.Date;
@Getter @Setter
public class Users {

    private Long id;


    private String usuario;


    private String paswoord;


    private Integer estado;


    private Date fechaCrea;


    private Date fechaMod;

    private PersonsEntity persons;

    private String role;

    public Users(Long id, String usuario, String paswoord, Integer estado, Date fechaCrea, Date fechaMod, PersonsEntity persons, String role) {
        this.id = id;
        this.usuario = usuario;
        this.paswoord = paswoord;
        this.estado = estado;
        this.fechaCrea = fechaCrea;
        this.fechaMod = fechaMod;
        this.persons = persons;
        this.role = role;
    }
}
