CREATE database vegyesbolt
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_hungarian_ci;

USE vegyesbolt;

CREATE TABLE selections(
	id int PRIMARY KEY AUTO_INCREMENT,
    selection_name varchar(50)
);
create TABLE positions(
	id int PRIMARY KEY AUTO_INCREMENT,
    position_name varchar(50)
);
CREATE table customers(
	id int PRIMARY KEY AUTO_INCREMENT,
    customer_name varchar(50),
    phone_number varchar(30)
);
CREATE TABLE employees(
	id int PRIMARY key AUTO_INCREMENT,
    employee_name varchar(50),
    phone_number varchar(30),
    hire_date date,
    salary decimal(5,2),
    position_id int
);
CREATE table products(
	id int PRIMARY KEY AUTO_INCREMENT,
    product_name varchar(50),
    amount int,
    price decimal(5,2),
    selection_id int,
    purchaser varchar(50)
);
CREATE TABLE sales(
	id int PRIMARY KEY AUTO_INCREMENT,
    sale_date date,
    paid decimal(5,2),
    employee_id int, 
    product_id int, 
    customer_id int
);

ALTER TABLE employees
add CONSTRAINT fk_position_id
FOREIGN KEY (position_id) REFERENCES positions(id);

ALTER TABLE products
ADD CONSTRAINT fk_selection_id
FOREIGN KEY (selection_id) REFERENCES selections(id);

ALTER TABLE sales 
ADD CONSTRAINT fk_employee_id
FOREIGN KEY (employee_id) REFERENCES employees(id);

ALTER TABLE sales 
ADD CONSTRAINT fk_product_id
FOREIGN KEY (product_id) REFERENCES products(id);

ALTER TABLE sales 
ADD CONSTRAINT fk_customer_id
FOREIGN KEY (customer_id) REFERENCES customers(id);