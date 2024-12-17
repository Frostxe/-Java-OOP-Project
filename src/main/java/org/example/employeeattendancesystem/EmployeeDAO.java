package org.example.employeeattendancesystem;

import org.example.employeeattendance.EmployeeAttendance;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDAO implements EmployeeDAOInterface {
    private final Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addEmployee(EmployeeAttendance.Employee employee) {
        String query = "INSERT INTO employees (name, department, hire_date) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getDepartment());
            statement.setDate(3, new java.sql.Date(employee.getHireDate().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(EmployeeAttendance.Employee employee) {
        String query = "UPDATE employees SET name = ?, department = ?, hire_date = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getDepartment());
            statement.setDate(3, new java.sql.Date(employee.getHireDate().getTime()));
            statement.setInt(4, employee.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int employeeId) {
        String query = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, employeeId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void markAttendance(int employeeId, Date date, boolean present) {
        String query = "INSERT INTO attendance (employee_id, date, present) VALUES (?, ?, ?) ON CONFLICT(employee_id, date) DO UPDATE SET present = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, employeeId);
            statement.setDate(2, new java.sql.Date(date.getTime()));
            statement.setBoolean(3, present);
            statement.setBoolean(4, present);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isPresent(int employeeId, Date date) {
        String query = "SELECT present FROM attendance WHERE employee_id = ? AND date = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, employeeId);
            statement.setDate(2, new java.sql.Date(date.getTime()));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getBoolean("present");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<EmployeeAttendance.Employee> getAllEmployees() {
        List<EmployeeAttendance.Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                employees.add(new EmployeeAttendance.Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDate("hire_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public List<EmployeeAttendance> getAttendance(int employeeId) {
        List<EmployeeAttendance> attendanceList = new ArrayList<>();
        String query = "SELECT date, present FROM attendance WHERE employee_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Date date = rs.getDate("date");
                boolean present = rs.getBoolean("present");
                attendanceList.add(new EmployeeAttendance(employeeId, date, present));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceList;
    }
}
