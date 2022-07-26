package com.example.giaphong.Service.impl;

import com.example.giaphong.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void findByusername() {
    }

    @Test
    void findAll() {
    }

    @Test
    void testFindAll() {
    }

    @Test
    void save() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void loadUserByUserName() {
    }
}