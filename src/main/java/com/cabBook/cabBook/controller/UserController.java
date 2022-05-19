package com.cabBook.cabBook.controller;

import com.cabBook.cabBook.model.User;
import com.cabBook.cabBook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    public UserService userService;


    @GetMapping("/Users")
    @ResponseBody
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }
}
