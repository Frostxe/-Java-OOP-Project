module org.example.employeeattendance {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.employeeattendance to javafx.fxml;
    exports org.example.employeeattendance;
    exports org.example.employeeattendancesystem;
    opens org.example.employeeattendancesystem to javafx.fxml;
}