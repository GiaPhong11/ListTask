package com.example.list_task.mapper;

import com.example.list_task.model.UserEntity;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserEntityMapper {

	int insert(UserEntity row);

	UserEntity findByUserName(String username);

}