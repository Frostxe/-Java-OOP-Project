package org.example.employeeattendancesystem;

import org.example.employeeattendance.EmployeeAttendance;

public interface EmployeeDAOInterface {
    void addEmployee(EmployeeAttendance.Employee employee);

    void updateEmployee(EmployeeAttendance.Employee employee);

    void deleteEmployee(int employeeId);
}
