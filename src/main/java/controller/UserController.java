package controller;

import enity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import service.UserService;

import javax.annotation.Resource;


@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
//    @Autowired
    private UserService userService;

    public void doStr() {
        userService.out();
        System.out.println("控制层");
    }
    public Student getUser(Integer id) {
        Student student = userService.getUser(id);
        System.out.println(student.getName());
        return student;
    }
    @RequestMapping("/login")
    @ResponseBody
    public String login() {
        //视图名，视图为：视图前缀+login+视图后缀，即 /WEB-INF/template/login.html
        return "login";
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register() {
        //视图名，视图为：视图前缀+login+视图后缀，即 /WEB-INF/template/login.html
        return "register";
    }
}
