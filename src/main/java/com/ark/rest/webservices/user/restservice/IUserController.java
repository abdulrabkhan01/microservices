package com.ark.rest.webservices.user.restservice;

import com.ark.rest.webservices.user.domain.User;

import java.util.List;

public interface IUserController {
    public User getUserById(long userId);
    public User save(User user);
    public List<User> getAllUsers();
}
