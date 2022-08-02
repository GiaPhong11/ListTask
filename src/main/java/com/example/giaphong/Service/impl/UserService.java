package com.example.giaphong.Service.impl;

import com.example.giaphong.Entities.UserEntityJPA;
import com.example.giaphong.Repository.UserRepository;
import com.example.giaphong.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntityJPA findByusername(String username) throws Exception {
        return userRepository.findByusername(username);
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
        UserEntityJPA users = userRepository.findByusername(username);
        return users;
    }

}
