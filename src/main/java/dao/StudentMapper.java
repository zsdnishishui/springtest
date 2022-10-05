package dao;

import entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface StudentMapper {

    public Student getUserById(Integer id);

    @Select("select * from student where id = #{id}")
    Student getByUserId(Integer id);
}
