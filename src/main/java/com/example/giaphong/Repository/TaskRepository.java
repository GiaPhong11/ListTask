package com.example.giaphong.Repository;

import com.example.giaphong.Entities.TaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Integer> {
    @Query(value = " SELECT * FROM tbl_tasks LIMIT 5", nativeQuery = true)
    public List<TaskEntity> find5task();
    @Query(value = "SELECT e.* FROM tbl_tasks e Where e.status like 'Open'", nativeQuery = true)
    public List<TaskEntity> findByStatus();
    @Query(value = "SELECT e.* FROM tbl_tasks e Where e.status like 'Inprogress'", nativeQuery = true)
    public List<TaskEntity> findByStatus2();
    @Query(value = "SELECT e.* FROM tbl_tasks e Where e.status like 'Done'", nativeQuery = true)
    public List<TaskEntity> findByStatus3();
    @Query(value = "SELECT e.* FROM tbl_tasks e Where e.title like %?1%" + " OR e.id LIKE %?1%"
            + " OR e.content LIKE %?1%" + " OR e.status LIKE %?1%", nativeQuery = true)
    public Page<TaskEntity> findByKeywork(String keywork, Pageable pageable);

}
