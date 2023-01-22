package com.example.demo.Users;

import com.example.demo.Student.Student;
import com.example.demo.Student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

        @Bean
        CommandLineRunner commandLineRunner(UserRepository repository) {

            return args -> {
                User USER1 = new User(


                        "khalidovski",
                        "MyPssword223"


                );


                repository.saveAll(

                        List.of(USER1)
                );




            };




}



}
