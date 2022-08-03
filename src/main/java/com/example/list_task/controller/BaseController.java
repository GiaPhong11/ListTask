package com.example.list_task.controller;

import com.example.list_task.entity.UserEntityJPA;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class BaseController {
    // Kiểm tra đã login hay chưa
        @ModelAttribute("isLogined")
    public boolean isLogined() {
        boolean isLogined = false;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            isLogined = true;
        }
        return isLogined;
    }

    // Trả về thông tin của đối tượng User
    @ModelAttribute("userLogined")
    public UserEntityJPA getUserLogined() {
        Object userLogined = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userLogined != null && userLogined instanceof UserDetails)
            return (UserEntityJPA) userLogined;

        return null;
    }

    @ModelAttribute("ProjectTitle")
    private String Title() {
        return "GiaPhong";
    }
}
