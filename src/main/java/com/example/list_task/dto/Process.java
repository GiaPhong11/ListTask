package com.example.list_task.dto;

import com.example.list_task.model.UserEntity;
import org.springframework.security.core.context.SecurityContextHolder;

public class Process {
    public static int getId_User(){
        return ((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }
}
