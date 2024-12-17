package org.example.employeeattendance;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class HelloController {

    @FXML
    private TableView<EmployeeAttendance> attendanceTable;
    @FXML
    private TableColumn<EmployeeAttendance, String> nameColumnAttendance;
    @FXML
    private TableColumn<EmployeeAttendance, String> departmentColumnAttendance;
    @FXML
    private TableColumn<EmployeeAttendance, Date> dateColumnAttendance;
    @FXML
    private TableColumn<EmployeeAttendance, Boolean> presentColumnAttendance;

    @FXML
    private TextField nameFieldAttendance;
    @FXML
    private TextField departmentFieldAttendance;
    @FXML
    private TextField dateFieldAttendance;

    private EmployeeAttendanceDAO employeeAttendanceDAO;

    public void initialize() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123");
            employeeAttendanceDAO = new EmployeeAttendanceDAO(connection);

            // Настраиваем отображение таблицы посещаемости
            nameColumnAttendance.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
            departmentColumnAttendance.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDepartment()));
            dateColumnAttendance.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDate()));
            presentColumnAttendance.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().isPresent()));

            loadAttendanceData();
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "Could not connect to the database.", AlertType.ERROR);
        }
    }

    @FXML

    public void addAttendance() {
        String name = nameFieldAttendance.getText();
        String department = departmentFieldAttendance.getText();
        String dateText = dateFieldAttendance.getText();

        if (!isValidDate(dateText)) {
            showAlert("Invalid Date", "Please enter a valid date in the format yyyy-MM-dd", AlertType.ERROR);
            return;
        }

        Date date = Date.valueOf(dateText);
        boolean isAdded = employeeAttendanceDAO.addAttendance(name, department, date, true);

        if (isAdded) {
            showAlert("Attendance Added", "Attendance has been recorded successfully", AlertType.INFORMATION);
            System.out.println("Attendance successfully added - " + name + ", " + department + ", " + date);
            loadAttendanceData();
        } else {
            showAlert("Error", "Failed to add attendance", AlertType.ERROR);
        }
    }


    @FXML
    public void deleteAttendance() {
        EmployeeAttendance selectedAttendance = attendanceTable.getSelectionModel().getSelectedItem();
        if (selectedAttendance != null) {
            boolean isDeleted = employeeAttendanceDAO.deleteAttendance(selectedAttendance.getId());

            if (isDeleted) {
                showAlert("Attendance Deleted", "Attendance record has been deleted.", AlertType.INFORMATION);
                loadAttendanceData();
            } else {
                showAlert("Error", "Failed to delete attendance.", AlertType.ERROR);
            }
        } else {
            showAlert("Selection Error", "Please select an attendance record to delete.", AlertType.ERROR);
        }
    }

    public void loadAttendanceData() {
        List<EmployeeAttendance> attendances = employeeAttendanceDAO.getAllAttendance();
        attendanceTable.getItems().setAll(attendances);
        attendanceTable.getItems().addAll(attendances);

        System.out.println("Attendance data reloaded.");
        attendances.forEach(System.out::println);  // Вывод данных в консоль.

    }

    private boolean isValidDate(String date) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private void clearAttendanceFields() {
        nameFieldAttendance.clear();
        departmentFieldAttendance.clear();
        dateFieldAttendance.clear();
    }

    private void showAlert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
