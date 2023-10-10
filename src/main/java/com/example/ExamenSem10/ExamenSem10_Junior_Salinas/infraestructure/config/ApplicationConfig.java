package com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.config;

import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.application.service.PersonsService;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.application.service.UsersService;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.application.useCase.PersonsUseCaseImpl;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.application.useCase.UsersUseCaseImpl;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.ports.out.PersonsRepositoryPort;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.domain.ports.out.UsersRepositoryPort;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.repository.PersonsJpaRepositoryAdapter;
import com.example.ExamenSem10.ExamenSem10_Junior_Salinas.infraestructure.repository.UsersJpaRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public PersonsService personsService(PersonsRepositoryPort personsRepositoryPort){
        return new PersonsService(new PersonsUseCaseImpl(personsRepositoryPort));

    }
    @Bean
    public PersonsRepositoryPort personsRepositoryPort(PersonsJpaRepositoryAdapter personsJpaRepositoryAdapter){
        return personsJpaRepositoryAdapter;
    }

    @Bean
    public UsersService usersService(UsersRepositoryPort usersRepositoryPort){
        return new UsersService(new UsersUseCaseImpl(usersRepositoryPort));

    }
    @Bean
    public UsersRepositoryPort usersRepositoryPort(UsersJpaRepositoryAdapter usersJpaRepositoryAdapter){
        return usersJpaRepositoryAdapter;
    }
}
