package com.cabBook.cabBook.service;

import com.cabBook.cabBook.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    static List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User(1,"Karan"));
        users.add(new User(2,"Komal"));
        users.add(new User(3,"nidhi"));
        users.add(new User(4,"manav"));
        users.add(new User(5,"manik"));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(Integer id) {
        User user = null;
        for (User u: users) {
            if (u.getId() == id) {
                user = u;
                break;
            }
        }
        return user;
    }

    public User getUserByIdAndName(Integer id, String name) {
        User user= null;
        for (User u: users) {
            if (u.getId() == id && u.getName().equalsIgnoreCase(name)) {
                user = u;
            }
        }
        return user;
    }

//    public static void main(String... args) {
//        UserService us = new UserService();
//        System.out.println(us.getAllUsers().toString());;
//    }

}
