package com.qunar.fresh2018.spring.dao;

import com.qunar.fresh2018.spring.model.User;

import java.util.List;


/**
 * @author sht
 */
public interface Dao {
    String SELECT_ALL = "SELECT * FROM user";
    String DELETE_ID = "UPDATE user SET is_useable=false WHERE USER_ID=";
    String QUERY_ID = "SELECT * FROM user WHERE USER_ID= ?";
    String UPDATE_ID = "UPDATE user SET USER_NAME=? ,IS_USEABLE=?, REMARKS=? ,AGE=? ,SEX=?,LAST_EDIT_TIME=? WHERE USER_ID= ?";
    String INSERT = "INSERT INTO user (user_name,age,sex,remarks,is_useable,create_time,last_edit_time) VALUES (?,?,?,?,?,?,?)";

    List<User> queryAll();

    public void deleteById(int id);

    User queryByID(int id);

    boolean updateUser(User user);

    boolean addUser(User user);
}
