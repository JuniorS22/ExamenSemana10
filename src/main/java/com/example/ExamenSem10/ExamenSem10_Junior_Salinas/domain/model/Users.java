package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.util.Date;

public class Users {
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String usuario;

    @Getter @Setter
    private String paswoord;

    @Getter @Setter
    private Integer estado;

    @Getter @Setter
    private Date fecha_crea;

    @Getter @Setter
    private Date fecha_mod;

    @Getter
    @Setter
    private Persons persons;

    public Users(Long id, String usuario, String paswoord, Integer estado, Date fecha_crea, Date fecha_mod, Persons persons) {
        this.id = id;
        this.usuario = usuario;
        this.paswoord = paswoord;
        this.estado = estado;
        this.fecha_crea = fecha_crea;
        this.fecha_mod = fecha_mod;
        this.persons = persons;
    }
}
