package com.zsd.service;

import com.zsd.dao.StudentMapper;
import com.zsd.dao.UserDao;
import com.zsd.entity.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@Service("userService")
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Resource
    private StudentMapper studentMapper;

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

    @Override
    public Student getUserByMapper(Integer id) {
        return studentMapper.getUserById(id);
    }

    @Override
    public Student getUserByNoXml(Integer id) {
        return studentMapper.getByUserId(id);
    }
}
