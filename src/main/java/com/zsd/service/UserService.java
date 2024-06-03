package com.zsd.service;

import com.zsd.entity.Student;

public interface UserService {
    public void out();

    public Student getUser(Integer id);

    public Student getUserByMapper(Integer id);

    public Student getUserByNoXml(Integer id);
}
