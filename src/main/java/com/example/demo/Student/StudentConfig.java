package com.example.demo.Student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {


        @Bean
        CommandLineRunner commandLineRunner(StudentRepository repository) {

        return args -> {
            Student Meryem = new  Student(

                    "Meryem",
                    "MeryMoon@Springboot.com",
                    "2000",
                    22

            );

            Student khalid = new  Student(

                    "khalid",
                    "khalidovski@Springboot.com",
                    "1999",
                    23);

            repository.saveAll(

                    List.of(Meryem , khalid)
            );




        };




    }


}
