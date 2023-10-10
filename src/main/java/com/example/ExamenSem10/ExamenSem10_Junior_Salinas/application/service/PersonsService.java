package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.application.service;

import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model.Persons;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.ports.in.PersonsUseCase;

import java.util.List;
import java.util.Optional;

public class PersonsService implements PersonsUseCase {

    private PersonsUseCase personsUseCase;

    public PersonsService(PersonsUseCase personsUseCase) {
        this.personsUseCase = personsUseCase;
    }

    @Override
    public List<Persons> buscarTodos() {
        return personsUseCase.buscarTodos();
    }

    @Override
    public Optional<Persons> busPorId(Long id) {
        return personsUseCase.busPorId(id);
    }

    @Override
    public Persons guardar(Persons persons) {
        return personsUseCase.guardar(persons);
    }

    @Override
    public Persons actualizar(Persons persons) {
        return personsUseCase.actualizar(persons);
    }

    @Override
    public void eliminar(Long id) {
        personsUseCase.eliminar(id);
    }
}
