package com.example.demo.Users;


import com.example.demo.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/User")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> GetUsers(){

        return userService.getUsers();


    }


    @PostMapping
    public void registerNewUser(@RequestBody User user){

        userService.AddNewUser(user);

    }




    @DeleteMapping(path = "{userId}")
    public void DeleStudent(@PathVariable("userId") Long userId ){

        userService.DeleUser(userId);


    }




}

