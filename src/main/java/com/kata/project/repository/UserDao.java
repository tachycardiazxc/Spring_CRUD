package com.kata.project.repository;
import com.kata.project.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    void delete(long id);

    void patch(User user);

    List<User> get();

    User getById(long id);

}
