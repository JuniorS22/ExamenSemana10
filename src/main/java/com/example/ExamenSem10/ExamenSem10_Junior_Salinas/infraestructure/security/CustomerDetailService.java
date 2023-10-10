package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.security;

import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.entity.UsersEntity;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.repository.UsersJpaRepository;
import lombok.Getter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class CustomerDetailService implements UserDetailsService {
    private final UsersJpaRepository usersJpaRepository;


    private UsersEntity userDetail;

    public CustomerDetailService(UsersJpaRepository usersJpaRepository) {
        this.usersJpaRepository = usersJpaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userDetail=usersJpaRepository.findByUsuario(username);
        if(!Objects.isNull(userDetail)){
            return new User(userDetail.getUsuario(),userDetail.getPaswoord(),new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User not found");
        }
    }
    public UsersEntity getUserDetail(){
        return userDetail;
    }
}
