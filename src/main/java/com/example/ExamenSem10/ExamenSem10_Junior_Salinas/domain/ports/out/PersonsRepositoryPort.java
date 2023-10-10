package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.ports.out;

import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model.Persons;

import java.util.List;
import java.util.Optional;

public interface PersonsRepositoryPort {

    List<Persons> findAll();
    Optional<Persons> findById(Long id);
    Persons save(Persons persons);
    Persons update(Persons persons);
    void   delete(Long id);
}
