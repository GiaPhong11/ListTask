package com.example.list_task.service.impl;

import com.example.list_task.entity.UserEntityJPA;
import com.example.list_task.repository.UserRepository;
import com.example.list_task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntityJPA findByUserName(String username) throws Exception {
        return userRepository.findByUserName(username);
    }

    @Override
    public List<UserEntityJPA> findAll() {
        return userRepository.findAll();
    }


    @Override
    public Page<UserEntityJPA> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public <S extends UserEntityJPA> S save(S entity) {
        return userRepository.save(entity);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public UserEntityJPA loadUserByUserName(String username) {
        UserEntityJPA users = userRepository.findByUserName(username);
        return users;
    }

}
