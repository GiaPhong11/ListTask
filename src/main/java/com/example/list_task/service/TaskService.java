package com.example.list_task.service;


import com.example.list_task.model.TaskEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    TaskEntity findById2(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskEntity row);

    TaskEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TaskEntity row);

    List<TaskEntity> findAll();

    Page<TaskEntity> findTasks(Optional<Integer> page, Optional<String> title, Optional<String> status);
}
