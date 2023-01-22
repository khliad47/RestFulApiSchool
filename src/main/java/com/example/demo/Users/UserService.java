package com.example.demo.Users;


import com.example.demo.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {


    @Autowired
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    public List<User> getUsers(){


        return userRepository.findAll();

    }
    public void AddNewUser(User user) {


        Optional<User> UserOptional =  userRepository.findUserByUsername(user.getUsername());
        if (UserOptional.isPresent()){

            throw new IllegalStateException("Username Already Taken");

        }
            userRepository.save(user);

    }


    public void DeleUser(Long userId) {

        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("Student with id "+   userId   +"Does not exist");
        }
        userRepository.deleteById(userId);

    }




}
