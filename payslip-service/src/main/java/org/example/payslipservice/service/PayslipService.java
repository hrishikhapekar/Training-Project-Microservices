package org.example.payslipservice.service;

import org.example.payslipservice.model.Attendance;
import org.example.payslipservice.model.Employee;
import org.example.payslipservice.model.Payslip;

import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

@Service
public class PayslipService {

    private final RestTemplate restTemplate;

    public PayslipService(
            RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    public Payslip generatePayslip(
            int employeeId) {

        Employee employee =
                restTemplate.getForObject(
                        "http://EMPLOYEE-SERVICE/employees/" + employeeId,
                        Employee.class
                );

        Attendance attendance =
                restTemplate.getForObject(
                        "http://ATTENDANCE-SERVICE/attendance/" + employeeId,
                        Attendance.class
                );

        double salary =
                employee.getSalaryPerDay()
                        * attendance.getDaysPresent();

        return new Payslip(
                employee.getId(),
                employee.getName(),
                attendance.getDaysPresent(),
                salary
        );
    }
}