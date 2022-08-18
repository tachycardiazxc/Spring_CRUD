package com.kata.project.services;

import com.kata.project.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    void delete(long id);

    void patch(long id, User user);

    List<User> get();

    User getById(long id);

}