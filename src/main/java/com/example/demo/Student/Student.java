package com.example.demo.Student;

import jakarta.persistence.*;

@Entity
@Table




public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName =  "student_sequence",
            allocationSize = 1
    )


    @GeneratedValue(

            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"


    )
    private long id;
    private String name;
    private String email;
    private String dob;
    private int age;

    public Student() {
    }

    public Student(long id, String name, String email, String dob, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }


    public Student(String name, String email, String dob, int age) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", age=" + age +
                '}';
    }
}
