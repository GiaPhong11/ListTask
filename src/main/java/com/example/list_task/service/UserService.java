package com.example.list_task.service;

import com.example.list_task.entity.UserEntityJPA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {


    UserEntityJPA findByUserName(String username) throws Exception;

    abstract List<UserEntityJPA> findAll();


    abstract Page<UserEntityJPA> findAll(Pageable pageable);


    <S extends UserEntityJPA> S save(S entity);


    abstract void deleteAll();

    UserEntityJPA loadUserByUserName(String username);
}
