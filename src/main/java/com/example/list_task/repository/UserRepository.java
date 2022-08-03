package com.example.list_task.repository;

import com.example.list_task.entity.UserEntityJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntityJPA,Integer> {
    @Query(value = "SELECT e.* FROM tbl_users e Where e.username like %?1%", nativeQuery = true)
    UserEntityJPA findByUserName(String username);
}
