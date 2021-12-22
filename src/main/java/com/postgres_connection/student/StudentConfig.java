package com.postgres_connection.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student s1, s2;
            s1 = new Student(
                    "jiiia",
                    "j@gmai.com",
                    LocalDate.of(2000, Month.JANUARY, 22)
                    );

            s2 = new Student(
                    "xyzz",
                    "abc@gmai.com",
                    LocalDate.of(2001, 3, 3)
                    );

            repository.saveAll(List.of(s1,s2));
        };
    }
}