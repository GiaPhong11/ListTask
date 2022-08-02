package com.example.giaphong.Service.impl;

import com.example.giaphong.Entities.TaskEntityJPA;
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
    public List<TaskEntityJPA> findAll() {
        return taskrepo.findAll();
    }



    @Override
    public Page<TaskEntityJPA> findByKeywork(String keywork, Pageable pageable) {
        return taskrepo.findByKeywork(keywork, pageable);
    }


    @Override
    public Page<TaskEntityJPA> findByStatus(String status, Pageable pageable) {
        return taskrepo.findByStatus(status, pageable);
    }



    @Override
    public Page<TaskEntityJPA> findAll(Pageable pageable) {
        return taskrepo.findAll(pageable);
    }

    @Override
    public List<TaskEntityJPA> findAllById(Iterable<Integer> integers) {
        return taskrepo.findAllById(integers);
    }


    @Override
    public TaskEntityJPA findById(int id) {
        // TODO Auto-generated method stub
        return taskrepo.findById(id).get();
    }
    @Override
    public <S extends TaskEntityJPA> S save(S entity) {
        return taskrepo.save(entity);
    }


    @Override
    public void deleteById(Integer integer) {
        taskrepo.deleteById(integer);
    }

    @Override
    public void delete(TaskEntityJPA entity) {
        taskrepo.delete(entity);
    }

}
