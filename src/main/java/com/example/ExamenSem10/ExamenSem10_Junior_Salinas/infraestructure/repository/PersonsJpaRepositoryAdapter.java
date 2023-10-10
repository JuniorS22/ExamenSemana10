package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.repository;

import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model.Persons;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.ports.out.PersonsRepositoryPort;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.entity.PersonsEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonsJpaRepositoryAdapter implements PersonsRepositoryPort {

    private final PersonsJpaRepository personsJpaRepository;

    public PersonsJpaRepositoryAdapter(PersonsJpaRepository personsJpaRepository) {
        this.personsJpaRepository = personsJpaRepository;
    }

    @Override
    public List<Persons> findAll() {

        return personsJpaRepository.findByEstado(1);
    }

    @Override
    public Optional<Persons> findById(Long id) {
        return personsJpaRepository.findById(id).map(PersonsEntity::toDomainModel);
    }

    @Override
    public Persons save(Persons persons) {
        PersonsEntity personsEntity=PersonsEntity.fromDomainModel(persons);
        PersonsEntity savePersonsEntity = personsJpaRepository.save(personsEntity);
        return savePersonsEntity.toDomainModel();
    }

    @Override
    public Persons update(Persons persons) {
        PersonsEntity personsEntity=PersonsEntity.fromDomainModel(persons);
        PersonsEntity updatedPersonsEntity = personsJpaRepository.save(personsEntity);
        return updatedPersonsEntity.toDomainModel();
    }

    @Override
    public void delete(Long id) {

        Optional<Persons> personExistente = findById(id);

        if (personExistente.isPresent()){

            PersonsEntity personEntity = PersonsEntity.fromDomainModel(personExistente.get());

            if (personEntity.getEstado() == 1){
                personEntity.setEstado(0);
                personsJpaRepository.save(personEntity);
            }
        }
    }
}
