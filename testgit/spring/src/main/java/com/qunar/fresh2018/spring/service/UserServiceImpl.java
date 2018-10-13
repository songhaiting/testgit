package com.qunar.fresh2018.spring.service;

import com.qunar.fresh2018.spring.dao.UserDao;
import com.qunar.fresh2018.spring.model.User;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service("userService") public class UserServiceImpl implements UserService {
    @Resource(name = "userDao") private UserDao userDao;
    //@Autowired private UserDao userDao;

    @Override public List<User> getAllUsers() {
        return userDao.queryAll();
    }

    @Override public void delete(int id) {
        userDao.delete(id);
    }

    @Override public User getUserById(int id) {
        return userDao.queryById(id);
    }

    @Override public void update(User user) {
        userDao.update(user);
    }

    @Override public void addUser(User user) {
        userDao.addUser(user);
    }
}