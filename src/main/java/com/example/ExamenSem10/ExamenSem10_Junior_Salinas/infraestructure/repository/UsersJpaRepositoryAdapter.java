package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.repository;

import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model.Persons;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model.Users;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.ports.out.UsersRepositoryPort;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.entity.PersonsEntity;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.entity.UsersEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UsersJpaRepositoryAdapter implements UsersRepositoryPort {

    private final UsersJpaRepository usersJpaRepository;

    public UsersJpaRepositoryAdapter(UsersJpaRepository usersJpaRepository) {
        this.usersJpaRepository = usersJpaRepository;
    }


    @Override
    public List<Users> findAll() {
        //return usersJpaRepository.findByEstado(1);
        List<UsersEntity> usersEntities = usersJpaRepository.findAll();

        List<Users> users = new ArrayList<>();

        usersEntities.forEach(user -> {
            users.add(user.toDomainModel());
        });

        return users;
    }

    @Override
    public Optional<Users> findById(Long id) {
        return usersJpaRepository.findById(id).map(UsersEntity::toDomainModel);
    }

    @Override
    public Users save(Users users) {
        UsersEntity usersEntity=UsersEntity.fromDomainModel(users);
        UsersEntity saveUsersEntity = usersJpaRepository.save(usersEntity);
        return saveUsersEntity.toDomainModel();
    }

    @Override
    public Users update(Users users) {
        UsersEntity usersEntity=UsersEntity.fromDomainModel(users);
        UsersEntity updatedUsersEntity = usersJpaRepository.save(usersEntity);
        return updatedUsersEntity.toDomainModel();
    }

    @Override
    public void delete(Long id) {

        Optional<Users> usersExistente = findById(id);

        if (usersExistente.isPresent()){

            UsersEntity usersEntity = UsersEntity.fromDomainModel(usersExistente.get());

            if (usersEntity.getEstado() == 1){
                usersEntity.setEstado(0);
                usersJpaRepository.save(usersEntity);
            }
        }

    }
}
