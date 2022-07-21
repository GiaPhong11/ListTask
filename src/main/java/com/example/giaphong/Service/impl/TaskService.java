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

    public List<TaskEntity> findAll() {
        return taskrepo.findAll();
    }

    public List<TaskEntity> findAllById(Iterable<Integer> integers) {
        return taskrepo.findAllById(integers);
    }

    public <S extends TaskEntity> List<S> saveAll(Iterable<S> entities) {
        return taskrepo.saveAll(entities);
    }

    public <S extends TaskEntity> S saveAndFlush(S entity) {
        return taskrepo.saveAndFlush(entity);
    }

    public <S extends TaskEntity> List<S> findAll(Example<S> example) {
        return taskrepo.findAll(example);
    }

    public <S extends TaskEntity> S save(S entity) {
        return taskrepo.save(entity);
    }

    public Optional<TaskEntity> findById(Integer integer) {
        return taskrepo.findById(integer);
    }

    public <S extends TaskEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return taskrepo.findAll(example, pageable);
    }
    public Page<TaskEntity> findAll(Pageable pageable) {
        return taskrepo.findAll(pageable);
    }
    public void deleteById(Integer integer) {
        taskrepo.deleteById(integer);
    }

    public void delete(TaskEntity entity) {
        taskrepo.delete(entity);
    }

    public <S extends TaskEntity> Optional<S> findOne(Example<S> example) {
        return taskrepo.findOne(example);
    }
}
