package com.example.giaphong.Repository;

import com.example.giaphong.Entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Integer> {
    @Query(value = " SELECT * FROM tbl_tasks LIMIT 5", nativeQuery = true)
    public List<TaskEntity> findProduct();
}
