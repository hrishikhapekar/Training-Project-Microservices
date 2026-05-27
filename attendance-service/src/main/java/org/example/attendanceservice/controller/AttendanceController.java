package org.example.attendanceservice.controller;

import org.example.attendanceservice.model.Attendance;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @GetMapping("/{employeeId}")

    public Attendance getAttendance(
            @PathVariable int employeeId) {

        if(employeeId == 1) {

            return new Attendance(
                    1,
                    24
            );
        }

        else if(employeeId == 2) {

            return new Attendance(
                    2,
                    20
            );
        }

        else if(employeeId == 3) {

            return new Attendance(
                    3,
                    26
            );
        }

        return new Attendance(
                employeeId,
                10
        );
    }
}