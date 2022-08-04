package com.example.list_task.controller;

import com.example.list_task.model.UserEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class BaseController {
    // Kiểm tra đã login hay chưa
    @ModelAttribute("isLoggedIn")
    public boolean isLogined() {
        boolean isLoggedIn = false;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            isLoggedIn = true;
        }
        return isLoggedIn;
    }

    // Trả về thông tin của đối tượng User
    @ModelAttribute("loggedInUser")
    public UserEntity getloggedInUser() {
        Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser != null && loggedInUser instanceof UserDetails)
            return (UserEntity) loggedInUser;

        return null;
    }

    @ModelAttribute("ProjectTitle")
    private String Title() {
        return "GiaPhong";
    }
}
