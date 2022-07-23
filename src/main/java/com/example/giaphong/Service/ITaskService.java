package com.example.giaphong.Service;


import com.example.giaphong.Entities.TaskEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ITaskService {

    List<TaskEntity> findAll();

    Page<TaskEntity> findAll(Pageable pageable);

    List<TaskEntity> findAllById(Iterable<Integer> integers);

    <S extends TaskEntity> List<S> saveAll(Iterable<S> entities);

    <S extends TaskEntity> S saveAndFlush(S entity);

    <S extends TaskEntity> List<S> findAll(Example<S> example);

    <S extends TaskEntity> S save(S entity);

    Optional<TaskEntity> findById(Integer integer);

    <S extends TaskEntity> Page<S> findAll(Example<S> example, Pageable pageable);

    void deleteById(Integer integer);

    void delete(TaskEntity entity);

    <S extends TaskEntity> Optional<S> findOne(Example<S> example);
}
