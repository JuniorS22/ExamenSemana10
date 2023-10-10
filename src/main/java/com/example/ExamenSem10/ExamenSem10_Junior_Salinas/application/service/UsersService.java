package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.application.service;

import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model.Users;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.ports.in.UsersUseCase;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UsersService implements UsersUseCase {

    private UsersUseCase usersUseCase;

    public UsersService(UsersUseCase usersUseCase) {
        this.usersUseCase = usersUseCase;
    }

    @Override
    public List<Users> buscarTodos() {
        return usersUseCase.buscarTodos();
    }

    @Override
    public Optional<Users> busPorId(Long id) {
        return usersUseCase.busPorId(id);
    }

    @Override
    public Users guardar(Users users) {
        return usersUseCase.guardar(users);
    }

    @Override
    public Users actualizar(Users users) {
        return usersUseCase.actualizar(users);
    }

    @Override
    public void eliminar(Long id) {
        usersUseCase.eliminar(id);
    }

    @Override
    public String login(Map<String, String> requestMap) {
        return usersUseCase.login(requestMap);
    }
}
