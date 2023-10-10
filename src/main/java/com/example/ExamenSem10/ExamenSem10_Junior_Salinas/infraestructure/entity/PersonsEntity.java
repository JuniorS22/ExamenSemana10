package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.entity;

import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model.Persons;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name="Persons")
public class PersonsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String email;
    private String telefono;
    private Integer estado;

    @CreatedDate
    @Column(name = "fecha_crea", nullable = false, updatable = false)
    private Date fechaCrea;

    @LastModifiedDate
    @Column(name = "fecha_mod")
    private Date fechaMod;

    public PersonsEntity() {
    }

    public PersonsEntity(Long id, String nombre, String apellidos, String direccion, String email, String telefono, Integer estado, Date fechaCrea, Date fechaMod) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.estado = estado;
        this.fechaCrea = fechaCrea;
        this.fechaMod = fechaMod;
    }

    public static PersonsEntity fromDomainModel(Persons persons){
        return new PersonsEntity(persons.getId(),
                persons.getNombre(),
                persons.getApellidos(),
                persons.getDireccion(),
                persons.getEmail(),
                persons.getTelefono(),
                persons.getEstado(),
                persons.getFecha_crea(),
                persons.getFecha_mod());
    }
    public Persons toDomainModel(){
        return new Persons(id,nombre,apellidos,direccion,email,telefono,estado,fechaCrea,fechaMod);
    }
}
