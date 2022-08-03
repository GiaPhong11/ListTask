package com.example.list_task.service;


import com.example.list_task.entity.TaskEntityJPA;
import com.example.list_task.model.TaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    int deleteByPrimaryKey(Integer id);

    int insert(TaskEntity row);

    TaskEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TaskEntity row);

    Page<TaskEntityJPA> findByKeyword(String keyword, Pageable pageable);

    List<TaskEntity> findAll();

    Page<TaskEntityJPA> findByStatus(String status, Pageable pageable);


    Page<TaskEntityJPA> findAll(Pageable pageable);


    TaskEntityJPA findById(int id);

    Page<TaskEntity> findTasks(Optional<Integer> page, Optional<String> title, Optional<String> status);
}
