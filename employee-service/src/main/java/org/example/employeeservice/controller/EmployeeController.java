package org.example.employeeservice.controller;

import org.example.employeeservice.model.Employee;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping("/{id}")

    public Employee getEmployee(
            @PathVariable int id) {

        if(id == 1) {

            return new Employee(
                    1,
                    "Hrishi",
                    1000
            );
        }

        else if(id == 2) {

            return new Employee(
                    2,
                    "Rahul",
                    1500
            );
        }

        else if(id == 3) {

            return new Employee(
                    3,
                    "Amit",
                    2000
            );
        }

        return new Employee(
                id,
                "Unknown",
                500
        );
    }
}