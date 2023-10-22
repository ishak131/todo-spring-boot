package com.asset.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class TodoApplication {


    public static void main(String[] args) {

        SpringApplication.run(TodoApplication.class, args);
    }

}
