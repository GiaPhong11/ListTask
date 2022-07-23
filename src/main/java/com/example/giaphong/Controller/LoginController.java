package com.example.giaphong.Controller;

import com.example.giaphong.DTO.SimpleUser;
import com.example.giaphong.Entities.UserEntity;
import com.example.giaphong.Service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;



    @GetMapping("")
    public String Home(){
        return "login";
    }

    @PostMapping("/save-login")
    public String saveLogin(Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){

        //1: Lấy thông tin người dùng đẩy lên
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        return "login";
    }

    @GetMapping("/register")
    public String Register(Model model){
        model.addAttribute("user", new SimpleUser());
        return "register";
    }

    @PostMapping("/process_register")
    public String processRegister(UserEntity user){
        userService.save(user);
        return "register_success";
    }
}
