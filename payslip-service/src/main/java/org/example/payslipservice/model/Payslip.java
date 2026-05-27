package org.example.payslipservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payslip {

    private int employeeId;

    private String employeeName;

    private int daysPresent;

    private double monthlySalary;
}