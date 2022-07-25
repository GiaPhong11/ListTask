package com.example.giaphong.Repository;

import com.example.giaphong.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    @Query(value = "SELECT e.* FROM tbl_users e Where e.username like %?1%", nativeQuery = true)
    UserEntity findByusername(String username);
}
