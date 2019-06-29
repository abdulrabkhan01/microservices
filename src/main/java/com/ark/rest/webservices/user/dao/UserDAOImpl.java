package com.ark.rest.webservices.user.dao;

import com.ark.rest.webservices.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDAOImpl implements IUserDAO {



    private static int currId = 6;
    private static List<User> userList = new ArrayList<>();

    static {
       userList.add(new User(1,"ark","98901","bpl"));
        userList.add(new User(2,"srk","98902","mum"));
        userList.add(new User(3,"mrk","98903","ind"));
        userList.add(new User(4,"krk","98904","pun"));
        userList.add(new User(5,"drk","98905","pun"));
        userList.add(new User(6,"mrk","98906","bpl"));

    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }

    @Override
    public User getUserById(long id) {

       Optional<User> user = userList.stream().filter(u -> u.getId() == id).findFirst();
        return user.isPresent() ? user.get() : null;
    }

    @Override
    public User save(User u) {
        if (u.getId()==0) {
            u.setId(++currId);
        }
        userList.add(u);
        return u;
    }
}
