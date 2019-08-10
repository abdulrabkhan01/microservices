package com.ark.rest.webservices.user.restservice;

import com.ark.rest.webservices.user.dao.UserDAOImpl;
import com.ark.rest.webservices.user.domain.Post;
import com.ark.rest.webservices.user.domain.User;
import com.ark.rest.webservices.user.restservice.util.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
    public Resource<User> getUser(@PathVariable long id) {
        User user = userDAO.getUserById(id);

        if (user == null) {
            throw new UserNotFoundException("User Not found with Id "+id);
        }

        //Hateoas - create link to retreive all users
        Resource<User> resource = new Resource<>(user);
        ControllerLinkBuilder linkto =
        ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllUsers());
        resource.add(linkto.withRel("all-users"));

        return resource;    }

    @GetMapping(path ="hello1")
    public String newHello() {
        return "this is test hello";
    }


    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {

        User savedUser = userDAO.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public   void deleteUser(@PathVariable long id) {
        userDAO.deleteUser(id);
    }

    @GetMapping("users/{id}/posts/{postId}")
    public Post getPostsByUserAndPostId(@PathVariable long id, @PathVariable long postId) {
      return userDAO.getPostByUserIdAndPostId(id, postId);
    }

}
