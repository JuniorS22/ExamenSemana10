package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.application.useCase;

import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model.Persons;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.ports.in.PersonsUseCase;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.ports.out.PersonsRepositoryPort;

import java.util.List;
import java.util.Optional;

public class PersonsUseCaseImpl implements PersonsUseCase {

    private final PersonsRepositoryPort personsRepositoryPort;

    public PersonsUseCaseImpl(PersonsRepositoryPort personsRepositoryPort) {
        this.personsRepositoryPort = personsRepositoryPort;
    }



    @Override
    public List<Persons> buscarTodos() {
        return personsRepositoryPort.findAll();
    }

    @Override
    public Optional<Persons> busPorId(Long id) {
        return personsRepositoryPort.findById(id);
    }

    @Override
    public Persons guardar(Persons persons) {
        return personsRepositoryPort.save(persons);
    }

    @Override
    public Persons actualizar(Persons persons) {
        return personsRepositoryPort.update(persons);
    }

    @Override
    public void eliminar(Long id) {
        personsRepositoryPort.delete(id);
    }
}
