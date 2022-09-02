package com.example.employeeDatabase.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/hello")
    public List<Employee> json() {
        return employeeService.getEmployeesDetails();
    }

    @PostMapping("postEmployeeName")
    public void registerEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @DeleteMapping(path = "{emp_id}")
    public  void deleteStudents(@PathVariable("emp_id") Long emp_id){
            employeeService.deleteEmployee(emp_id);
    }
}
