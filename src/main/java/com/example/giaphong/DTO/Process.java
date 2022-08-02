package com.example.giaphong.DTO;

import com.example.giaphong.Entities.UserEntityJPA;
import org.springframework.security.core.context.SecurityContextHolder;

public class Process {
    private String id;
    private String username;

    public static int getId_User(){
        return ((UserEntityJPA)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }
}
