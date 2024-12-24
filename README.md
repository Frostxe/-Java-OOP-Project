# Employee Attendance System

## Table of Contents
1. [Description](#description)
2. [Project Requirements](#project-requirements)
3. [Team Members](#team-members)
4. [Roles of Group Members](#roles-of-group-members)
5. [Screenshots](#screenshots)
6. [Sample Data](#sample-data)
7. [Weekly Meeting Documentation](#weekly-meeting-documentation)
8. [OOP Concepts and questions](#oop-concepts-and-questions)
9. [Presentation](#presentation)
10. [Github Repository](#github-repository)
11. [Jar File Build](#jar-file-build)
---

## Description
The **Employee Attendance System** is an application designed to automate the tracking of employee attendance. It allows for recording attendance, absences, and tardiness, as well as generating detailed reports for each employee. This project showcases the application of object-oriented programming (OOP) principles using the Java programming language.

---

## Project Requirements
Below are the 10 key functionalities of the system:

1. **Employee Registration**: Employees can be registered in the system with basic details such as ID, name, and position.
2. **Clock-in and Clock-out Recording**: The system records employees' clock-in and clock-out times.
3. **Tardiness and Overtime Calculation**: Automatically calculates tardiness and overtime.
4. **Data Validation**: Ensures all data is validated during updates.
5. **Data Storage**: Uses collections to store attendance information.
6. **Report Generation**: Generates attendance reports for each employee.
7. **Employee List Display**: Displays a list of all employees and their current attendance status.
8. **Console Interface**: Manages data and interactions through a console-based interface.
9. **Error Handling**: Handles errors and exceptions gracefully.
10. **OOP Optimization**: Implements key OOP principles, including inheritance, encapsulation, and polymorphism.

---

## Team Members
- **Sabyrbekova Asel**
- **Torobekov Arsen**
- **Chetymbaev Omurbek**

---

## Roles of Group Members
- **Database, Presentation**: Torobekov Arsen
- **Code Integration**: Chetymbaev Omurbek
- **Interface Design, Documentation**: Sabyrbekova Asel


## Screenshots
Below are key screenshots showcasing the application:

Home:
![image](https://github.com/user-attachments/assets/87e400b4-609b-4e19-8ce8-cb00ad78c691)

Employee:
![image](https://github.com/user-attachments/assets/ffe561a0-e611-4b69-8058-21c77c6bc0bc) 
![image](https://github.com/user-attachments/assets/090b696c-aaca-4a1e-901c-7c93ac743dbc)
![image](https://github.com/user-attachments/assets/316de5ea-f203-42e0-99a2-58db0dff836b)

Project:
![image](https://github.com/user-attachments/assets/1a21e055-07b3-4d30-b4a9-a3a952293b23)
![image](https://github.com/user-attachments/assets/6730b701-9aa9-42e8-b250-b1ccb6a1c167)
![image](https://github.com/user-attachments/assets/b5d04f84-2544-46c5-a9b1-eb4df94d8f10)

Trash:
![image](https://github.com/user-attachments/assets/822920d5-32db-4659-a870-af5784bb768c)
![image](https://github.com/user-attachments/assets/4cbf9a86-9cbb-4d29-b01a-0a9dd3af48ce)

Attendance grade:
![image](https://github.com/user-attachments/assets/150b1e3c-88ed-4c56-9df6-0f78b2ab2b25)
![image](https://github.com/user-attachments/assets/03adb40c-7864-4ec2-b41f-f4c01b9e7ce2)
![image](https://github.com/user-attachments/assets/9ca93070-ccc5-4c3e-a660-4bd0eb21fce5)

Database:

![image](https://github.com/user-attachments/assets/6dab5010-d270-4ece-af4e-07b50046dbcd)
![image](https://github.com/user-attachments/assets/1f0d553a-824d-4734-b366-b01511bf0d1e)
![image](https://github.com/user-attachments/assets/e614c0f0-2259-45c3-9bd9-0d75bd0c0e5b)
![image](https://github.com/user-attachments/assets/0cba12a5-3835-4d88-866d-8d928078fd58)
![image](https://github.com/user-attachments/assets/9f8cd69f-a055-4c01-b380-cce5517e46b4)

## Sample Data
It is possible in PostgreSQL: 
```
-- Insert data into the employees table
INSERT INTO employees (name, department, hire_date)
VALUES 
('Alice Johnson', 'HR', '2020-05-15'),
('Bob Smith', 'IT', '2018-03-20'),
('Charlie Brown', 'Finance', '2019-07-10'),
('Diana White', 'IT', '2021-01-25'),
('Eve Black', 'Marketing', '2022-08-05');

-- Insert data into the grades table
INSERT INTO grades (employee_id, grade)
VALUES 
(1, 'Present'),
(2, 'Excused'),
(3, 'Absent'),
(4, 'Late'),
(5, 'Present');

-- Insert data into the projects table
INSERT INTO projects (title, description, start_date, end_date)
VALUES
('Cloud Migration', 'Migrate the company infrastructure to the cloud', '2023-01-01', '2023-06-30'),
('Budget Analysis', 'Perform a detailed analysis of company expenses', '2023-02-15', NULL),
('Marketing Campaign', 'Launch a new social media campaign', '2023-03-01', '2023-05-15');

-- Insert data into the trash table
INSERT INTO trash (employee_id, name, department, grade, hire_date)
VALUES 
(999, 'John Doe', 'Research', 7.5, '2021-12-01');

```
This is also possible by simply running our application and filling the table with this data through the application.

## OOP Concepts and questions

### 1. **Encapsulation**
**Explanation:**  
Encapsulation is used to protect data by making fields private and providing public getter and setter methods to access and modify them.

**Code Example:**
```java
public class Employee {
    private final StringProperty name;
    private final StringProperty department;
    private final Date hireDate;
    private int id;
    private boolean attendanceStatus;

    public Employee(int id, String name, String department, Date hireDate) {
        this.id = id;
        this.name = new SimpleStringProperty(name);
        this.department = new SimpleStringProperty(department);
        this.hireDate = hireDate;
        this.attendanceStatus = false; // Default status
    }

    // Getter for name
    public String getName() {
        return name.get();
    }

    // Setter for name
    public void setName(String name) {
        this.name.set(name);
    }

    // Getter and setter for attendance status
    public boolean getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(boolean status) {
        this.attendanceStatus = status;
    }
}

```

### 2. **Access Modifiers**
**Explanation:**  
Access modifiers control the visibility of classes, methods, and variables. `private` hides the fields from outside, while `public` makes them accessible.

**Code Example:**
```java
public class EmployeeDAO {
    private final Connection connection;  // private access to the connection

    // public method accessible from outside
    public void markAttendance(Employee employee, boolean status) {
        employee.setAttendanceStatus(status);  // Update attendance status
        // Logic to update the database with the new status
    }
}

```

### 3. **Constructor**
**Explanation:**  
Constructors are used to initialize objects with a valid state at the time of creation.

**Code Example:**
```java
public Employee(int id, String name, String department, Date hireDate) {
    this.id = id;
    this.name = new SimpleStringProperty(name);
    this.department = new SimpleStringProperty(department);
    this.hireDate = hireDate;
    this.attendanceStatus = false; // Default attendance status
}

```

### 4. **Method Overloading**
**Explanation:**  
Method overloading allows multiple methods with the same name but different parameters, enabling the handling of different input types.

**Code Example:**
```java
public void markAttendance(int employeeId, boolean status) {
    // Mark attendance for an employee by ID
}

public void markAttendance(List<Employee> employees, boolean status) {
    // Mark attendance for multiple employees at once
    for (Employee employee : employees) {
        employee.setAttendanceStatus(status);
    }
}

```

### 5. **Exception Handling**
**Explanation:**  
Exception handling is used to manage errors, ensuring the application does not crash due to unexpected issues.

**Code Example:**
```java
try {
    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EmployeeAttendance", "postgres", "123");
} catch (SQLException e) {
    e.printStackTrace();
    showAlert("Database Error", "Could not connect to the database.");
}

```

### 6. **Inheritance**
**Explanation:**  
Inheritance allows a class (e.g., `EmployeeGrade`) to reuse properties and methods from a parent class (`Employee`).

**Code Example:**
```java
public class EmployeeGrade extends Employee {
    private String grade;

    public EmployeeGrade(int id, String name, String department, Date hireDate, String grade) {
        super(id, name, department, hireDate); 
        this.grade = grade;
    }
```

### 7. **Method Overriding**
**Explanation:**  
Method overriding allows subclasses to provide specific implementations of methods defined in a superclass.

**Code Example:**
```java
@Override
public boolean getAttendanceStatus() {
    // Override to include custom logic for full-time employees, if needed
    return super.getAttendanceStatus();
}

```

### 8. **Interface**
**Explanation:**  
Interfaces define common behavior for classes to implement, ensuring consistency across different implementations.

**Code Example:**
```java
public interface EmployeeDAOInterface {
    void markAttendance(Employee employee, boolean status);
    void updateEmployeeAttendance(Employee employee);
}

public class EmployeeDAO implements EmployeeDAOInterface {
    @Override
    public void markAttendance(Employee employee, boolean status) {
        employee.setAttendanceStatus(status);
        // Implement logic to persist the attendance status to the database
    }

    @Override
    public void updateEmployeeAttendance(Employee employee) {
        // Implement logic to update the employee's attendance record in the database
    }
}

```

### 9. **Polymorphism**
**Explanation:**  
Polymorphism allows the handling of objects of different types in a uniform way, typically through a common interface or superclass.

**Code Example:**
```java
List<Employee> employees = new ArrayList<>();
employees.add(new FullTimeEmployee(1, "John", "HR", new Date(), 50000));
employees.add(new PartTimeEmployee(2, "Alice", "Engineering", new Date(), 20));

// Polymorphism in action
for (Employee e : employees) {
    System.out.println(e.getName());  // Works for both FullTimeEmployee and PartTimeEmployee
    // Track attendance
    employeeDAO.markAttendance(e, true);
}

```

### 10. **Dependency Injection**
**Explanation:**  
Dependency Injection reduces tight coupling by passing dependencies (e.g., `EmployeeDAO`) to a class rather than creating them inside.

**Code Example:**
```java
public class AttendanceService {
    private final EmployeeDAO employeeDAO;

    // Dependency Injection via constructor
    public AttendanceService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void recordAttendance(Employee employee, boolean status) {
        employeeDAO.markAttendance(employee, status);
    }
}

```

## Presentation
The project's presentation, I did with free platform "Canva", you can download presentation in PDF-format: [Canva Presentation](https://www.canva.com/design/DAGZkp1BJeE/0lVkIlS-GoOwB-L4KGHaMg/edit?utm_content=DAGZkp1BJeE&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)


## GitHub Repository
The project source code and documentation can be accessed on GitHub at [GitHub Repository Link](https://github.com/Frostxe/EmployeeAtteandanceSystem/tree/main).

## Jar File Build
Installation requirements:
1. https://gluonhq.com/products/javafx/ - JavaFX
2. https://www.oracle.com/java/technologies/downloads/?er=221886#jdk23-windows - Java Downloads
3. https://johann.loefflmann.net/en/software/jarfix/index.html - Jarfix

You need to provide the path to the JavaFX file
