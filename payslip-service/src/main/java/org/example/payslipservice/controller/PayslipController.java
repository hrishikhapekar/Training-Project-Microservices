package org.example.payslipservice.controller;

import org.example.payslipservice.model.Payslip;

import org.example.payslipservice.service.PayslipService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payslip")
public class PayslipController {

    private final PayslipService payslipService;

    public PayslipController(
            PayslipService payslipService) {

        this.payslipService = payslipService;
    }

    @GetMapping("/{employeeId}")

    public Payslip getPayslip(
            @PathVariable int employeeId) {

        return payslipService.generatePayslip(
                employeeId
        );
    }
}