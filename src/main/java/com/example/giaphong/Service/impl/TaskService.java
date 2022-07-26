package com.example.giaphong.Service.impl;

import com.example.giaphong.Entities.TaskEntity;
import com.example.giaphong.Repository.TaskRepository;
import com.example.giaphong.Service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {
    @Autowired
    private TaskRepository taskrepo;

    @Override
    public List<TaskEntity> findAll() {
        return taskrepo.findAll();
    }

    @Override
    public Page<TaskEntity> findAll(Pageable pageable) {
        return taskrepo.findAll(pageable);
    }

    @Override
    public List<TaskEntity> findAllById(Iterable<Integer> integers) {
        return taskrepo.findAllById(integers);
    }


    @Override
    public <S extends TaskEntity> S save(S entity) {
        return taskrepo.save(entity);
    }


    @Override
    public void deleteById(Integer integer) {
        taskrepo.deleteById(integer);
    }

    @Override
    public void delete(TaskEntity entity) {
        taskrepo.delete(entity);
    }

}
