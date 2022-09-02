package com.example.employeeDatabase.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmployeeConfig {
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
            Employee employee1 = new Employee(
                    "ned",
                    21
            );

            Employee employee2 = new Employee(
                    "Tom",
                    24
            );

            Employee employee3 = new Employee(
                    "Rob",
                    28
            );


            employeeRepository.saveAll(List.of(employee1, employee2, employee3));
        };
    }
}
