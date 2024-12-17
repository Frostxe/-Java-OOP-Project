package org.example.employeeperformanceapp;

import org.example.employeeattendance.EmployeeAttendance;

import java.sql.Date;
import java.util.List;

public interface EmployeeDAOinterface {

    default void addAttendance(EmployeeAttendance attendance) {

    }

    void updateAttendance(EmployeeAttendance attendance);
    void deleteAttendance(int attendanceId);
    List<EmployeeAttendance> getAllAttendance();
    EmployeeAttendance getAttendanceById(int attendanceId);

    boolean attendanceExists(int employeeId, Date date);
}
