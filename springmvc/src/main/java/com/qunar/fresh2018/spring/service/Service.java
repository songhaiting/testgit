package com.qunar.fresh2018.spring.service;

import com.qunar.fresh2018.spring.model.User;

import java.util.List;


/**
 * @author sht
 */
public interface Service {
    List<User> queryAll();

    public void deleteById(int id);

    User queryByID(int id);

    boolean updateUser(User user);

    boolean addUser(User user);
}
