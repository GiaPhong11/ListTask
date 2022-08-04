package com.example.list_task.service.impl;

/*import com.example.list_task.entity.UserEntityJPA;*/
import com.example.list_task.mapper.UserEntityMapper;
import com.example.list_task.model.UserEntity;
/*import com.example.list_task.repository.UserRepository;*/
import com.example.list_task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserEntityMapper userMapper;

    public UserServiceImpl(UserEntityMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserEntity findByUserName(String username) throws Exception  {
        return userMapper.findByUserName(username);
    }

    @Override
    public int insert(UserEntity row) {
        return userMapper.insert(row);
    }

    @Override
    public UserEntity loadUserByUserName(String username) {
        UserEntity users = userMapper.findByUserName(username);
        return users;
    }



}
