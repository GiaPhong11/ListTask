package com.example.list_task.service.impl;

import com.example.list_task.model.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailServiceImpl implements UserDetailsService{

	private final UserServiceImpl userService;

	public UserDetailServiceImpl(UserServiceImpl userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userService.loadUserByUserName(username);
		return user;
	}

}
