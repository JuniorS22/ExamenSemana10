package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.repository;


import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.model.Users;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.ports.out.UsersRepositoryPort;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.entity.UsersEntity;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.security.CustomerDetailService;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.security.jwt.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class UsersJpaRepositoryAdapter implements UsersRepositoryPort {

    private final UsersJpaRepository usersJpaRepository;

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CustomerDetailService customerDetailService;

    public UsersJpaRepositoryAdapter(UsersJpaRepository usersJpaRepository, AuthenticationManager authenticationManager, JwtUtil jwtUtil, CustomerDetailService customerDetailService) {
        this.usersJpaRepository = usersJpaRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.customerDetailService = customerDetailService;
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

    @Override
    public String login(Map<String, String> requestMap) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestMap.get("usuario"), requestMap.get("password")));
            if(authentication.isAuthenticated()){
                String token_generado = jwtUtil.generateToken(
                        customerDetailService.getUserDetail().getUsuario(),
                        customerDetailService.getUserDetail().getRole()
                );
                return token_generado;
            }

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
