package com.example.list_task.mapper;

import com.example.list_task.model.TaskEntity;
import com.example.list_task.model.TaskEntityExample;
import java.util.List;

import com.example.list_task.model.enums.TaskStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TaskEntityMapper<findById> {

    int deleteByPrimaryKey(Integer id);

    int insert(TaskEntity row);

    TaskEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TaskEntity row);

    List<TaskEntity> findAll();

    List<TaskEntity> findById(@Param("id") Integer id);

    List<TaskEntity> findByTitleContaining(@Param("title") String title, @Param("page") Pageable pageable);

    int countByTitle(@Param("title") String title);

    int countTasksFilterTitle(@Param("title") String title);

    List<Task> findAllPage(@Param("page") Pageable pageable);

    Integer countAllTasks();

    Integer countTasksFilterTitleAndStatus(@Param("title") String title, @Param("status") TaskStatus status);

    List<Task> findByTitleContainingAndTaskStatus(@Param("title") String title,
                                                  @Param("status") TaskStatus status,
                                                  @Param("page") Pageable pageable);

    List<Task> findByTaskStatus(@Param("status") TaskStatus status, @Param("page") Pageable pageable);

    Integer countTasksFilterStatus(@Param("status")TaskStatus status);

}