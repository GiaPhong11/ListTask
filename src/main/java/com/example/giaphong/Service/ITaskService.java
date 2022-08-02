package com.example.giaphong.Service;


import com.example.giaphong.Entities.TaskEntityJPA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITaskService {

    List<TaskEntityJPA> findAll();


    Page<TaskEntityJPA> findByKeywork(String keywork, Pageable pageable);

    Page<TaskEntityJPA> findByStatus(String status, Pageable pageable);



    Page<TaskEntityJPA> findAll(Pageable pageable);

    List<TaskEntityJPA> findAllById(Iterable<Integer> integers);

    TaskEntityJPA findById(int id);

    <S extends TaskEntityJPA> S save(S entity);

    void deleteById(Integer integer);

    void delete(TaskEntityJPA entity);


}
