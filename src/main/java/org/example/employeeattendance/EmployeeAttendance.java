package org.example.employeeattendance;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EmployeeAttendance {
    public EmployeeAttendance(int employeeId, Date date, boolean present) {
    }

    public String getDepartment() {
        return "";
    }

    public String getName() {
        return null;
    }

    public java.sql.Date getDate() {
        return null;
    }

    public Boolean isPresent() {
        return null;
    }

    public Object getId() {
        return null;
    }

    public static class Employee {
        private int id;
        private final StringProperty name;
        private final StringProperty department;
        private final Date hireDate;
        private final Map<Date, Boolean> attendance;  // Календарь присутствия (дата -> присутствует/нет)

        public Employee(int id, String name, String department, Date hireDate) {
            this.id = id;
            this.name = new SimpleStringProperty(name);
            this.department = new SimpleStringProperty(department);
            this.hireDate = hireDate;
            this.attendance = new HashMap<>();
        }

        // Свойства JavaFX для привязки данных
        public StringProperty nameProperty() {
            return name;
        }

        public StringProperty departmentProperty() {
            return department;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name.get();
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public String getDepartment() {
            return department.get();
        }

        public void setDepartment(String department) {
            this.department.set(department);
        }

        public Date getHireDate() {
            return hireDate;
        }

        // Методы для управления посещаемостью
        public void markAttendance(Date date, boolean present) {
            attendance.put(date, present);
        }

        public boolean isPresent(Date date) {
            return attendance.getOrDefault(date, false);
        }

        public Map<Date, Boolean> getAttendance() {
            return attendance;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + getName() + '\'' +
                    ", department='" + getDepartment() + '\'' +
                    ", hireDate=" + hireDate +
                    '}';
        }
    }
}
