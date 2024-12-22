CREATE TABLE employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(100),
    hire_date DATE
);
CREATE TABLE grades (
    employee_id INT,
    grade VARCHAR(20),  -- Store grade as a string ("Absent", "Excused", "Present")
    PRIMARY KEY (employee_id),
    FOREIGN KEY (employee_id) REFERENCES employees(id) ON DELETE CASCADE
);
CREATE TABLE employee_grades (
    employee_id INT,
    name VARCHAR(100),
    department VARCHAR(100),
    hire_date DATE,
    grade VARCHAR(20),
    PRIMARY KEY (employee_id),
    FOREIGN KEY (employee_id) REFERENCES employees(id) ON DELETE CASCADE
);

CREATE TABLE trash (
    id SERIAL PRIMARY KEY,
    employee_id INT,
    name VARCHAR(100),
    department VARCHAR(50),
    grade FLOAT,
    hire_date DATE,
    deleted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE projects (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    start_date DATE NOT NULL,
    end_date DATE,
    CHECK (end_date IS NULL OR end_date > start_date)
);