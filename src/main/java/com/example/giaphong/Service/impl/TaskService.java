package com.example.giaphong.Service.impl;

import com.example.giaphong.Entities.TaskEntity;
import com.example.giaphong.Repository.TaskRepository;
import com.example.giaphong.Service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService {
    @Autowired
    private TaskRepository taskrepo;

    @Override
    public List<TaskEntity> findAll() {
        return taskrepo.findAll();
    }


    @Override
    public Page<TaskEntity> findByKeywork(String keywork, Pageable pageable) {
        return taskrepo.findByKeywork(keywork, pageable);
    }

    @Override
    public List<TaskEntity> findByStatus2() {
        return taskrepo.findByStatus2();
    }


    @Override
    public List<TaskEntity> findByStatus3() {
        return taskrepo.findByStatus3();
    }

    @Override
    public List<TaskEntity> findByStatus() {
        return taskrepo.findByStatus();
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
    public TaskEntity findById(int id) {
        // TODO Auto-generated method stub
        return taskrepo.findById(id).get();
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
