package com.example.employeeDatabase.employee;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployeesDetails() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long emp_id) {
       boolean found =  employeeRepository.existsById(emp_id);
        if (!found) {
            throw new IllegalStateException("employee id " + emp_id + " deoesn't exists");
        }
        else {
            employeeRepository.deleteById(emp_id);
        }
    }
}
