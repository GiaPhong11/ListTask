package com.example.giaphong.Service;

import com.example.giaphong.Entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUserService {


    UserEntity findByusername(String username) throws Exception;

    abstract List<UserEntity> findAll();


    abstract Page<UserEntity> findAll(Pageable pageable);


    <S extends UserEntity> S save(S entity);


    abstract void deleteAll();

    UserEntity loadUserByUserName(String username);
}
