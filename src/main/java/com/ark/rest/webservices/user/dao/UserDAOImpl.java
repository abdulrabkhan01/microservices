package com.ark.rest.webservices.user.dao;

import com.ark.rest.webservices.user.domain.Post;
import com.ark.rest.webservices.user.domain.User;
import com.ark.rest.webservices.user.restservice.util.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserDAOImpl implements IUserDAO {



    private static int currId = 6;
    private static List<User> userList = new ArrayList<>();

    static {
       userList.add(new User(1,"ark","98901","bpl", Arrays.asList(new Post[] {new Post(1, "This is post by user 1 based on cricket world cup"), new Post(2, "This is post by user 1 for football")} )));
        userList.add(new User(2,"srk","98902","mum",Arrays.asList(new Post[] {new Post(3, "This post is by user 2")})));
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

    public void deleteUser(long userId) {
        User u = getUserById(userId);
        if (u == null) {
            throw new UserNotFoundException("User Not Found with Id "+userId);
        }
        userList.remove(u);

    }

    public Post getPostByUserIdAndPostId(long userId,long postId) {
        User user = getUserById(userId);
        if (user == null) {
            throw new UserNotFoundException("User Not Found with Id "+userId);
        }
        List<Post> posts = user.getPosts();
        if (posts == null || posts.isEmpty()) {
            throw new RuntimeException("No Post found for user "+userId+" with post id "+postId);
        }
        Optional<Post> post = posts.stream().filter(p -> p.getId() == postId).findFirst();
        return post.isPresent() ? post.get() : null ;
    }
}
