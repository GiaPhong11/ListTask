package com.example.giaphong.Service.impl;

import com.example.giaphong.Entities.UserEntity;
import com.example.giaphong.Repository.UserRepository;
import com.example.giaphong.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity findByusername(String username) throws Exception{
            return  userRepository.findByusername(username);


    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public <S extends UserEntity> List<S> saveAll(Iterable<S> entities) {
        return userRepository.saveAll(entities);
    }

    @Override
    public Page<UserEntity> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public <S extends UserEntity> S save(S entity) {
        return userRepository.save(entity);
    }

    @Override
    public Optional<UserEntity> findById(Integer integer) {
        return userRepository.findById(integer);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public UserEntity loadUserByUserName(String username) {
        UserEntity users = userRepository.findByusername(username);
        return users;
    }

}
