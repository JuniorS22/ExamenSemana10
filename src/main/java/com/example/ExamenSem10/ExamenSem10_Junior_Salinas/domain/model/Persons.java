package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

public class Persons {

    @Getter
    @Setter
    private Long id;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String apellidos;

    @Getter @Setter
    private String direccion;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String telefono;

    @Getter @Setter
    private Integer estado;

    @Getter @Setter
    private Date fecha_crea;

    @Getter @Setter
    private Date fecha_mod;

    public Persons(Long id, String nombre, String apellidos, String direccion, String email, String telefono, Integer estado, Date fecha_crea, Date fecha_mod) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.estado = estado;
        this.fecha_crea = fecha_crea;
        this.fecha_mod = fecha_mod;
    }
}
