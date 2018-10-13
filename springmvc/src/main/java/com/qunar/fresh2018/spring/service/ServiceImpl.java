package com.qunar.fresh2018.spring.service;

import com.qunar.fresh2018.spring.dao.Dao;
import com.qunar.fresh2018.spring.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author sht
 */
@Service("serviceImpl")
@Transactional
public class ServiceImpl implements com.qunar.fresh2018.spring.service.Service {
    @Resource(name = "daoImpl")
    private Dao daoImpl;

    public ServiceImpl() {
    }

    @Override
    public List<User> queryAll() {
        return daoImpl.queryAll();
    }

    @Override
    public void deleteById(int id) {
        daoImpl.deleteById(id);
    }

    @Override
    public User queryByID(int id) {
        return daoImpl.queryByID(id);
    }

    @Override
    public boolean updateUser(User user) {
        return daoImpl.updateUser(user);
    }

    @Override
    public boolean addUser(User user) {
        return daoImpl.addUser(user);
    }

}
