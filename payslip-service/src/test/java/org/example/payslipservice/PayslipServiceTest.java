package org.example.payslipservice;

import org.example.payslipservice.model.Attendance;
import org.example.payslipservice.model.Employee;
import org.example.payslipservice.model.Payslip;
import org.example.payslipservice.service.PayslipService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PayslipServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PayslipService payslipService;

    @Test
    void testGeneratePayslip() {

        Employee employee = new Employee(
                1,
                "Hrishi",
                1000
        );

        Attendance attendance = new Attendance(
                1,
                20
        );

        when(
                restTemplate.getForObject(
                        anyString(),
                        eq(Employee.class)
                )
        ).thenReturn(employee);

        when(
                restTemplate.getForObject(
                        anyString(),
                        eq(Attendance.class)
                )
        ).thenReturn(attendance);

        Payslip payslip =
                payslipService.generatePayslip(1);

        assertEquals(
                20000,
                payslip.getMonthlySalary()
        );

        assertEquals(
                "Hrishi",
                payslip.getEmployeeName()
        );

        assertEquals(
                20,
                payslip.getDaysPresent()
        );
    }
}