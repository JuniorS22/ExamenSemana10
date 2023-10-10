package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.repository;

import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model.Users;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.entity.PersonsEntity;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersJpaRepository extends JpaRepository<UsersEntity,Long> {

    List<Users> findByEstado(int estado);

    UsersEntity findByUsuario(String usuario);
}
