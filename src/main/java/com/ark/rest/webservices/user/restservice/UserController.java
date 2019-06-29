package com.ark.rest.webservices.user.restservice;

import com.ark.rest.webservices.user.dao.IUserDAO;
import com.ark.rest.webservices.user.dao.UserDAOImpl;
import com.ark.rest.webservices.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements IUserController {


    @Autowired
    private UserDAOImpl userDAO;

    @Override
    public User getUserById(long userId) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        return userDAO.getUserById(id);
    }

    @GetMapping(path ="hello1")
    public String newHello() {
        return "this is test hello";
    }
}
