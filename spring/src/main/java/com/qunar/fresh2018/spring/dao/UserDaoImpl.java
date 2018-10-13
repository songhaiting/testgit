package com.qunar.fresh2018.spring.dao;


import com.google.common.base.Preconditions;
import com.qunar.fresh2018.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Component
@Repository("userDao") public class UserDaoImpl implements UserDao {

    @Autowired private JdbcTemplate jdbcTemplate;


    @Override public User queryById(int id) {
      /*  final String sql = "select name,age,email,remark,gender,usable,create_time,last_modified_time from t_users where id=?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);*/
        final String SQL = "select * from T_USERS where id=?";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(SQL, id);
        if (resultList.size() == 0) {
            return null;
        }
        Map<String, Object> rowMap = resultList.get(0);
        String name = (String) rowMap.get("name");
        String gender = (String) rowMap.get("gender");
        String phone = (String) rowMap.get("phone");
        String email =(String)rowMap.get("email");
        Integer age = (Integer) rowMap.get("age");
        String remark = (String) rowMap.get("remark");
        Integer usable = (Integer) rowMap.get("usable");
        Date createTime = (Date) rowMap.get("create_time");
        Date lastModified = (Date) rowMap.get("last_modified_time");
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        user.setPhone(phone);
        user.setRemark(remark);
        user.setGender(gender);
        user.setUsable(usable);
        user.setCreateTime(createTime);
        user.setLastModified(lastModified);
        return user;
    }

    @Override public List<User> queryAll() {
        final String sql = "select id,name,age,email,remark,gender,usable,create_time,last_modified_time from t_users where usable<>0";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> users = jdbcTemplate.query(sql, rowMapper);
        return users;
    }

    @Override public int addUser(User user) {
        final String sql = "insert into t_users(name,gender,age,phone,email,remark,create_time,last_modified_time) values(?,?,?,?,?,?,?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        return jdbcTemplate
                .update(sql, user.getName(),user.getGender(), user.getAge(), user.getPhone(),user.getEmail(), user.getRemark(),sdf.format(now),sdf.format(now));
    }

    @Override public int update(User user) {
        Preconditions.checkNotNull(user);
        final String sql = "update t_users set name=?,age=?,email=?,remark=?,gender=?,usable=1,last_modified_time=? where id=?";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return jdbcTemplate
                .update(sql,user.getName(), user.getAge(), user.getEmail(), user.getRemark(), user.getGender(),
                        sdf.format(new Date()),user.getId());

    }

    @Override public int delete(int id) {
        //String sql = "delete from t_users where id =?";
        String sql = "update t_users set usable = 0  where id =?";
        return jdbcTemplate.update(sql, new Object[] { id });
    }

    @Override public int delete(int[] ids) {
        int status = 1;
        for (int id : ids) {
            if (delete(id) == 0) {
                status = 0;
            }
        }
        return status;
    }

}