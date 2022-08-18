package com.kata.project.services;

import com.kata.project.model.User;
import com.kata.project.repository.UserDao;
import com.kata.project.repository.UserDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    public void patch(long id, User user) {
        userDao.patch(id, user);
    }

    @Override
    public List<User> get() {
        return userDao.get();
    }

    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }
}
