package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.application.useCase;

import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model.Users;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.ports.in.UsersUseCase;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.ports.out.UsersRepositoryPort;

import java.util.List;
import java.util.Optional;

public class UsersUseCaseImpl implements UsersUseCase {

    private final UsersRepositoryPort usersRepositoryPort;

    public UsersUseCaseImpl(UsersRepositoryPort usersRepositoryPort) {
        this.usersRepositoryPort = usersRepositoryPort;
    }

    @Override
    public List<Users> buscarTodos() {
        return usersRepositoryPort.findAll();
    }

    @Override
    public Optional<Users> busPorId(Long id) {
        return usersRepositoryPort.findById(id);
    }

    @Override
    public Users guardar(Users users) {
        return usersRepositoryPort.save(users);
    }

    @Override
    public Users actualizar(Users users) {
        return usersRepositoryPort.update(users);
    }

    @Override
    public void eliminar(Long id) {
        usersRepositoryPort.delete(id);
    }
}
