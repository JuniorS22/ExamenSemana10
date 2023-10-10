package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.ports.out;


import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model.Users;


import java.util.List;
import java.util.Optional;

public interface UsersRepositoryPort {

    List<Users> findAll();
    Optional<Users> findById(Long id);
    Users save(Users users);
    Users update(Users users);
    void   delete(Long id);
}
