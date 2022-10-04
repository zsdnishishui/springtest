package dao;

import enity.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

//@Repository("userDao")
@Repository
public class UserDaoImpl implements UserDao{

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void print() {
        System.out.println("dao实现类");
    }

    @Override
    public Student getUser(Integer id) {
        String sql = "SELECT * FROM `student` where `id`=?;";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class), id);
    }
}
