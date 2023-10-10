package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.repository;

import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model.Users;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.ports.out.UsersRepositoryPort;
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
        List<UsersEntity> usersEntity = usersJpaRepository.findAll();
        List<Users> users = new ArrayList<>();
        usersEntity.forEach(users1->{
            Users user=new Users(users1.getId(), users1.getUsuario(), users1.getPaswoord(),users1.getEstado(),users1.getFechaCrea(),users1.getFechaMod(),users1.getPersons().toDomainModel());


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
        usersJpaRepository.deleteById(id);
    }
}
