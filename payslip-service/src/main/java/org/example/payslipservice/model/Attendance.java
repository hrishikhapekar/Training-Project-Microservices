package org.example.payslipservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {

    private int employeeId;

    private int daysPresent;
}