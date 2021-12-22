package com.postgres_connection;

import com.postgres_connection.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class PostgresConnectionApplication {


    public static void main(String[] args) {

        SpringApplication.run(PostgresConnectionApplication.class, args);
        System.out.println("heyyy man");
    }

}
