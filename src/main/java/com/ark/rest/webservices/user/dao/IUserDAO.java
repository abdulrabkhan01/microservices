package com.ark.rest.webservices.user.dao;

import com.ark.rest.webservices.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

public interface IUserDAO {

    public List<User> getAllUsers();

    public User getUserById(long id);

    public User save(User u);
}
