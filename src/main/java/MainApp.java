

import controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//        HelloWorld obj = context.getBean("helloWorld",HelloWorld.class);
//        AopTest obj = context.getBean("aopTest",AopTest.class);
//        obj.getMessage();
        UserController userController = context.getBean("userController", UserController.class);
        userController.doStr();
//        userController.getUser(1);
    }
}