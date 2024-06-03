package com.zsd.dao;

import com.zsd.entity.Student;

public interface UserDao {
    public void print();

    public Student getUser(Integer id);
}
