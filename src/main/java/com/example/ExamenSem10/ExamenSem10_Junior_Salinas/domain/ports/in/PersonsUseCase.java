package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.ports.in;

import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model.Persons;

import java.util.List;
import java.util.Optional;

public interface PersonsUseCase {

    List<Persons> buscarTodos();
    Optional<Persons> busPorId(Long id);
    Persons guardar(Persons persons);
    Persons actualizar(Persons persons);
    void   eliminar(Long id);
}
