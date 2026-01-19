CREATE TABLE IF NOT EXISTS employee (
    employee_no BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(10) NOT NULL,
    firstname VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    dob DATE NOT NULL,
    gender VARCHAR(20) NOT NULL,
    email VARCHAR(150) NOT NULL,
    address TEXT NOT NULL,

    CONSTRAINT pk_employee PRIMARY KEY (employee_no),
    CONSTRAINT uq_employee_email UNIQUE (email)
) ENGINE=InnoDB;