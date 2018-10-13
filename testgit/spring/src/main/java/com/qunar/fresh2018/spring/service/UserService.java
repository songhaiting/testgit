package com.qunar.fresh2018.spring.service;

import com.qunar.fresh2018.spring.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void delete(int id);

    User getUserById(int id);

    void update(User user);

    void addUser(User user);
}