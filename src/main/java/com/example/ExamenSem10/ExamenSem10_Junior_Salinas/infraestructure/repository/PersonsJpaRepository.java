package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.repository;

import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.entity.PersonsEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonsJpaRepository extends JpaRepository<PersonsEntity,Long> {

    List<PersonsEntity> findByEstado(int estado);
}
