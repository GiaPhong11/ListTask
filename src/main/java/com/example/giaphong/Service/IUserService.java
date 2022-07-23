package com.example.giaphong.Service;

import com.example.giaphong.Entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUserService {


    abstract List<UserEntity> findAll();

    abstract <S extends UserEntity> List<S> saveAll(Iterable<S> entities);

    abstract Page<UserEntity> findAll(Pageable pageable);


    <S extends UserEntity> S save(S entity);

    abstract Optional<UserEntity> findById(Integer integer);

    abstract void deleteAll();

}
