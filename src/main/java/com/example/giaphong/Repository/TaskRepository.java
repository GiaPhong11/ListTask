package com.example.giaphong.Repository;

import com.example.giaphong.Entities.TaskEntityJPA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntityJPA,Integer> {

    @Query(value = "SELECT o FROM TaskEntityJPA o where o.status = ?1")
    public Page<TaskEntityJPA> findByStatus(String status, Pageable pageable);

   /* @Query(value = "SELECT e.* FROM tbl_tasks e Where e.title like %?1%"
            + " OR e.content LIKE %?1%" + " OR e.status LIKE %?1%", nativeQuery = true)*/
    @Query(value = "select o FROM TaskEntityJPA o where LOWER(o.title) like %?1% OR LOWER(o.content) " +
            "like %?1% OR LOWER(o.status) like %?1% OR UPPER(o.title) like %?1% " +
            "OR UPPER(o.content) like %?1% OR UPPER(o.status) like %?1%")
            /*"OR o.title = ?1 OR o.content like ?1 OR o.status like ?1" ,nativeQuery = true*/
    public Page<TaskEntityJPA> findByKeywork(String keywork, Pageable pageable);



}
