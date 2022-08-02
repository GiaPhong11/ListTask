package com.example.giaphong.Service;

import com.example.giaphong.Entities.UserEntityJPA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {


    UserEntityJPA findByusername(String username) throws Exception;

    abstract List<UserEntityJPA> findAll();


    abstract Page<UserEntityJPA> findAll(Pageable pageable);


    <S extends UserEntityJPA> S save(S entity);


    abstract void deleteAll();

    UserEntityJPA loadUserByUserName(String username);
}
