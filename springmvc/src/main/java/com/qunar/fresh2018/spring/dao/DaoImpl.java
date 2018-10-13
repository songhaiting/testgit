package com.qunar.fresh2018.spring.dao;


import com.qunar.fresh2018.spring.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * @author sht
 */
@Repository("daoImpl")
public class DaoImpl implements Dao {
    Logger logger = LoggerFactory.getLogger ( DaoImpl.class );

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public DaoImpl() {
    }

    @Override
    public List<User> queryAll() {
        return jdbcTemplate.query ( SELECT_ALL, (rs, rowNum) -> {
            Integer user_id = rs.getInt ( "user_id" );
            String user_name = rs.getString ( "user_name" );
            Integer age = rs.getInt ( "age" );
            String remarks = rs.getString ( "remarks" );
            boolean is_useable = rs.getBoolean ( "is_useable" );
            Date create_time = rs.getDate ( "create_time" );
            Date last_edit_time = rs.getDate ( "last_edit_time" );
            String sex = rs.getString ( "sex" );
            User user = new User ( );
            user.setUser_id ( user_id );
            user.setUser_name ( user_name );
            user.setAge ( age );
            user.setSex ( sex );
            user.setRemarks ( remarks );
            user.setIs_useable ( is_useable );
            user.setCreate_time ( create_time );
            user.setLast_edit_time ( last_edit_time );
            return user;
        } );
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.execute ( DELETE_ID + String.valueOf ( id ) );
    }

    @Override
    public User queryByID(int id) {
        User user = new User ( );
        jdbcTemplate.query ( QUERY_ID, new Object[]{id}, (rs, rowNum) -> {
            Integer user_id = rs.getInt ( "user_id" );
            String user_name = rs.getString ( "user_name" );
            Integer age = rs.getInt ( "age" );
            String remarks = rs.getString ( "remarks" );
            boolean is_useable = rs.getBoolean ( "is_useable" );
            Date create_time = rs.getDate ( "create_time" );
            Date last_edit_time = rs.getDate ( "last_edit_time" );
            String sex = rs.getString ( "sex" );
            user.setUser_id ( user_id );
            user.setUser_name ( user_name );
            user.setAge ( age );
            user.setSex ( sex );
            user.setRemarks ( remarks );
            user.setIs_useable ( is_useable );
            user.setCreate_time ( create_time );
            user.setLast_edit_time ( last_edit_time );
            return user;
        } );
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        int state = jdbcTemplate.update ( UPDATE_ID, new Object[
                ]{user.getUser_name ( ), user.getIs_useable ( ), user.getRemarks ( ), user.getAge ( ), user.getSex ( ), new java.sql.Date ( new Date ( ).getTime ( ) ), user.getUser_id ( )} );
        if (state < 1) {
            logger.info ( "执行更新失败,请检查用户是否存在！" );
            return false;

        } else {
            logger.info ( "更新成功！" );
            return true;
        }

    }

    @Override
    public boolean addUser(User user) {
        logger.info ( user.getSex ( ) + user.getUser_name ( ) );
        int state = jdbcTemplate.update ( INSERT, new Object[
                ]{user.getUser_name ( ), user.getAge ( ), user.getSex ( ), user.getRemarks ( ), user.getIs_useable ( ), new Date ( ), new Date ( )} );
        if (state < 1) {
            logger.info ( "数据插入失败！" );
            return false;
        } else {
            logger.info ( "数据插入成功！" );
            return true;
        }
    }
}
