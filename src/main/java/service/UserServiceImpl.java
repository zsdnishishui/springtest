package service;

import dao.UserDao;
import enity.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
//@Service("userService")
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;
//    public UserDao getUserDao() {
//        return userDao;
//    }
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }
    @Override
    public void out() {
        userDao.print();
        System.out.println("业务层实现类");
    }

    @Override
    public Student getUser(Integer id) {
        return userDao.getUser(id);
    }
}
