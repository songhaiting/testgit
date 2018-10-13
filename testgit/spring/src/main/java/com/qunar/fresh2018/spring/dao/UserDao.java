package com.qunar.fresh2018.spring.dao;

import com.qunar.fresh2018.spring.model.User;

import java.util.List;

public interface UserDao {
    User queryById(int id);

    List<User> queryAll();

    int addUser(User user);

    int update(User user);

    int delete(int id);

    int delete(int[] ids);

}