package Models;

import java.sql.Date;

public class Employees {
    String employee_name;
    String phone_number;
    Date hire_date;
    Double salary;
    Integer position_id;

    public Employees(String employee_name, String phone_number, Date hire_date, Double salary, Integer position_id) {
        this.employee_name = employee_name;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.salary = salary;
        this.position_id = position_id;
    }

    public String getName() {
        return employee_name;
    }

    public void setName(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = Date.valueOf(hire_date);
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getPosition_id() {
        return position_id;
    }

    public void setPosition_id(Integer position_id) {
        this.position_id = position_id;
    }
    
    
}
