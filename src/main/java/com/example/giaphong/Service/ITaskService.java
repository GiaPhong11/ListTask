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

    <S extends TaskEntity> S save(S entity);

    void deleteById(Integer integer);

    void delete(TaskEntity entity);


}
