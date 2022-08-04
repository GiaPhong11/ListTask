package com.example.list_task.controller;

/*import com.example.list_task.entity.UserEntityJPA;*/
import com.example.list_task.model.UserEntity;
import com.example.list_task.service.UserService;
import com.example.list_task.service.impl.UserServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController extends BaseController {

    private final UserService userService;

    public LoginController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String Home() {
        return "SingIn";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET) // -> action
    public String register(final Model model,
                           final HttpServletRequest request,
                           final HttpServletResponse response)
            throws IOException {

        model.addAttribute("regis", new UserEntity());

        return "SingUp"; // -> duong dan toi VIEW.
    }

    @RequestMapping(value = {"/login/false"}, method = RequestMethod.GET) // -> action
    public String loginFalse(final Model model,
                           final HttpServletRequest request,
                           final HttpServletResponse response)
            throws IOException {

        model.addAttribute("regis", new UserEntity());
        model.addAttribute("loi", "Dang nhat that bai");

        return "SingIn"; // -> duong dan toi VIEW.
    }


    @RequestMapping(value = {"/register"}, method = RequestMethod.POST) // -> action
    public String register(final Model model,
                           final HttpServletRequest request,
                           final @ModelAttribute("regis") UserEntity regis)
            throws Exception {
        String username = regis.getUsername();
        String password = regis.getPassword();
        String cfPassword = request.getParameter("repassword");
        if (password.compareTo(cfPassword) != 0) {
            model.addAttribute("loi", "Mật khẩu và xác thực mật khẩu khác nhau");
            return "SingUp";
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(regis.getPassword());
        regis.setPassword(encodedPassword);
        regis.setUsername(username);


        UserEntity user = userService.findByUserName(username);

        if (user == null) {
            userService.insert(regis);
            //b3: thong bao cho nguoi dung biet da luu thanh cong
            model.addAttribute("thong_bao", "Đăng ký thành công");

        } else {
            model.addAttribute("loi", "Tài khoản đã tồn tại");
        }
        return "SingUp"; // -> duong dan toi VIEW.
    }


}
