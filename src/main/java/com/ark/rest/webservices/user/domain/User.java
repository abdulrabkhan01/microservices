package com.ark.rest.webservices.user.domain;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class User {


    private long id;
    @Size(min=2, message = "Name should have min 2 characters.")
    private String name;
    @Size(max = 10)
    private String contactNo;
    @Size(min =2, max=40)
    private String address;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    private List<Post> posts = new ArrayList<>();

    public User() {
       super();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User(long id, @Size(min = 2, message = "Name should have min 2 characters.") String name, @Size(max = 10) String contactNo, @Size(min = 2, max = 40) String address, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
        this.posts = posts;
    }

    public User(long id, String name, String contactNo, String address) {

        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
    }
}
