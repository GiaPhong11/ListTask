package com.example.giaphong.Controller;

import com.example.giaphong.DTO.SimpleUser;
import com.example.giaphong.Entities.UserEntity;
import com.example.giaphong.Service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;


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

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST) // -> action
    public String saveContact(final Model model,
                              final HttpServletRequest request,
                              final HttpServletResponse response,
                              final @ModelAttribute("regis") UserEntity regis)
            throws Exception {
        //b1: lay thong tin nguoi dung day len
        //	String email = request.getParameter("txtEmail");
        //	String emailFromSpringForm = contact.getTxtEmail();
        String username = regis.getUsername();
        String password = regis.getPassword();
        String cfPassword = request.getParameter("repassword");
        if (password.compareTo(cfPassword) != 0) {
            model.addAttribute("loi", "Mật khẩu và xác thực mật khẩu khác nhau");
            return "SingUp";
        }
//		String email = regis.getEmail();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(regis.getPassword());
        regis.setPassword(encodedPassword);
        regis.setUsername(username);
        //@SuppressWarnings("unchecked")
//        UserEntity user = new UserEntity();

        UserEntity user = userService.findByusername(username);
//        }catch (Exception e){
//            model.addAttribute("loi","Tài khoản đã tồn tại");
//        }

        if (user == null) {
            userService.save(regis);
            //b3: thong bao cho nguoi dung biet da luu thanh cong
            model.addAttribute("thongbao", "Đăng ký thành công");

        } else {
            model.addAttribute("loi", "Tài khoản đã tồn tại");
        }
        //TODO b2: luu thong tin vao csdl


        //return "WEB-INF/views/user/home.jsp";
        return "SingUp"; // -> duong dan toi VIEW.
    }

/*    @PostMapping("/process_register")
    public String processRegister(UserEntity user){
        userService.save(user);
        return "register_success";
    }*/
}
