package com.zsd.dao;

import com.zsd.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface StudentMapper {

    public Student getUserById(Integer id);

    @Select("select * from student where id = #{id}")
    Student getByUserId(Integer id);

    @Insert("insert into student(id,name) values(#{id},#{name})")
    int addStudent(Student student);
}
