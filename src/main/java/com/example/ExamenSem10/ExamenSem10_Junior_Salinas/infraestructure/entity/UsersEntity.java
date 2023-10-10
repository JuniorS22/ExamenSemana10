package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.entity;

import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model.Persons;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model.Users;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name="Users")
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;

    private String paswoord;

    private Integer estado;

    @OneToOne
    private PersonsEntity persons;

    @CreatedDate
    @Column(name = "fecha_crea", nullable = false, updatable = false)
    private Date fechaCrea;

    @LastModifiedDate
    @Column(name = "fecha_mod")
    private Date fechaMod;



    public UsersEntity() {
    }


    public UsersEntity(Long id, String usuario, String paswoord, Integer estado, PersonsEntity persons, Date fechaCrea, Date fechaMod) {
        this.id = id;
        this.usuario = usuario;
        this.paswoord = paswoord;
        this.estado = estado;
        this.persons = persons;
        this.fechaCrea = fechaCrea;
        this.fechaMod = fechaMod;
    }

    public static UsersEntity fromDomainModel(Users users){
        return new UsersEntity(users.getId(),
                users.getUsuario(),
                users.getPaswoord(),
                users.getEstado(),
                PersonsEntity.fromDomainModel(users.getPersons()
                ),
                users.getFechaCrea(),
                users.getFechaMod());
    }
    public Users toDomainModel(){
        return new Users(id,usuario,paswoord,estado,persons.toDomainModel(),fechaCrea,fechaMod);
    }
}
