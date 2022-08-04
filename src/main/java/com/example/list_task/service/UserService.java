package com.example.list_task.service;

import com.example.list_task.model.UserEntity;

public interface UserService {


    UserEntity findByUserName(String username) throws Exception  ;

    int insert(UserEntity row);

    UserEntity loadUserByUserName(String username);
}
