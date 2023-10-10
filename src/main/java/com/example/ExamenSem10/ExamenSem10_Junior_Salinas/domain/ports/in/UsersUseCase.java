package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.ports.in;


import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model.Users;

import java.util.List;
import java.util.Optional;

public interface UsersUseCase {

    List<Users> buscarTodos();
    Optional<Users> busPorId(Long id);
    Users guardar(Users users);
    Users actualizar(Users users);
    void   eliminar(Long id);
}
