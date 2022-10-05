package dao;

import entity.Student;

public interface UserDao {
    public void print();

    public Student getUser(Integer id);
}
