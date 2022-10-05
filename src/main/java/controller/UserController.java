package controller;

import entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
        Student student = userService.getUserByNoXml(1);
        System.out.println(student.getName());
        return "login";
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register() {
        Student student = userService.getUserByMapper(1);
        System.out.println(student.getName());
        return "register";
    }
}
