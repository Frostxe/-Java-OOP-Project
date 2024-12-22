package org.example.employeeperformanceapp;

import java.util.Date;

public class EmployeeGrade extends Employee {
    private String grade;

    public EmployeeGrade(int id, String name, String department, Date hireDate, String grade) {
        super(id, name, department, hireDate); // Вызов конструктора из Employee
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

//    @Override
//    public String toString() {
//        return "Grade: " + grade;  // Подставьте поле или методы класса, которые хотите отобразить
//    }

}
