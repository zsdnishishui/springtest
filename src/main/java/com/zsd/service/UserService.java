package com.zsd.service;

import com.zsd.entity.Student;

public interface UserService {
    public void out();

    public Student getUser(Integer id);

    public Student getUserByMapper(Integer id);

    public Student getUserByNoXml(Integer id);

    /**
     * 主要是为了测试事务传递
     *
     * @return
     */
    int addStudent();
}
