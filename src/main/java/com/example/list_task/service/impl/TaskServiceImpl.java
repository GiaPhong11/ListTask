package com.example.list_task.service.impl;

import com.example.list_task.mapper.TaskEntityMapper;
import com.example.list_task.model.TaskEntity;
import com.example.list_task.model.enums.TaskStatus;
import com.example.list_task.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskEntityMapper taskMapper;

    public TaskServiceImpl(TaskEntityMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskEntity findById2(Integer id) {
        return taskMapper.findById2(id);
    }
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return taskMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TaskEntity row) {
        return taskMapper.insert(row);
    }

    @Override
    public TaskEntity selectByPrimaryKey(Integer id) {
        return taskMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(TaskEntity row) {
        return taskMapper.updateByPrimaryKey(row);
    }

    @Override
    public List<TaskEntity> findAll() {
        return taskMapper.findAll();
    }

   @Override
    public Page<TaskEntity> findTasks(Optional<Integer> page, Optional<String> title, Optional<String> status) {
        int currentPage = page.orElse(1);
        currentPage = Math.max(1, currentPage);
        Pageable pageable = PageRequest.of(currentPage - 1, 5);
        if (title.isPresent() && !title.get().equals("") && (status.isEmpty() || status.get().equals(""))) {
            List<TaskEntity> tasks = taskMapper.findByTitleContaining(title.get(), pageable);
            Integer countTasks = taskMapper.countTasksFilterTitle(title.get());
            return new PageImpl<>(tasks, pageable, countTasks);
        } else if (status.isPresent() && !status.get().equals("") && (title.isEmpty() || title.get().equals(""))) {
            String parseStatus = status.get().replaceAll("-", " ");
            var optionalTaskStatus = Arrays.stream(TaskStatus.values()).filter(s -> s.getCode().equals(parseStatus)).findFirst();
            if (optionalTaskStatus.isPresent()) {
                List<TaskEntity> tasks = taskMapper.findByTaskStatus(optionalTaskStatus.get(), pageable);
                Integer countTasks = taskMapper.countTasksFilterStatus(optionalTaskStatus.get());
                return new PageImpl<>(tasks, pageable, countTasks);
            } else {
                List<TaskEntity> tasks = taskMapper.findAllPage(pageable);
                Integer countTasks = taskMapper.countAllTasks();
                return new PageImpl<>(tasks, pageable, countTasks);
            }
        } else if (status.isPresent() && !status.get().equals("") && title.isPresent() && !title.get().equals("")) {
            String parseStatus = status.get().replaceAll("-", " ");
            var optionalTaskStatus = Arrays.stream(TaskStatus.values()).filter(s -> s.getCode().equals(parseStatus)).findFirst();
            if (optionalTaskStatus.isPresent()) {
                List<TaskEntity> tasks = taskMapper.findByTitleContainingAndTaskStatus(title.get(), optionalTaskStatus.get(), pageable);
                Integer countTasks = taskMapper.countTasksFilterTitleAndStatus(title.get(), optionalTaskStatus.get());
                return new PageImpl<>(tasks, pageable, countTasks);
            } else {
                List<TaskEntity> tasks = taskMapper.findByTitleContaining(title.get(), pageable);
                Integer countTasks = taskMapper.countTasksFilterTitle(title.get());
                return new PageImpl<>(tasks, pageable, countTasks);
            }
        } else {
            List<TaskEntity> tasks = taskMapper.findAllPage(pageable);
            Integer countTasks = taskMapper.countAllTasks();
            return new PageImpl<>(tasks, pageable, countTasks);
        }
    }


}
