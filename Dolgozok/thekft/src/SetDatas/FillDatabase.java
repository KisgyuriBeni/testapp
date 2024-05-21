package SetDatas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.Customers;
import Models.Employees;
import Models.Positions;
import Models.Products;
import Models.Selections;

public class FillDatabase {
    String username = "root";
    String password = "";
    String url = "jdbc:mariadb://localhost:3306/vegyesbolt";
    Connection conn;
    PreparedStatement ps;

    public void storePositions(ArrayList<Positions> posiList) throws SQLException{
        conn = DriverManager.getConnection(url, username, password);
        String sql = 
        """
        INSERT INTO positions(position_name)
        VALUES(?);        
        """;
        for(Positions positions : posiList){
            ps = conn.prepareStatement(sql);
            ps.setString(1, positions.getName());
            ps.execute();
        }
        ps.close();
        System.out.println("Positions tábla feltöltve!");
    }
    public void storeSelections(ArrayList<Selections> selecList) throws SQLException{
        conn = DriverManager.getConnection(url, username, password);
        String sql = 
        """
        INSERT INTO selections(selection_name)
        VALUES(?);        
        """;
        for(Selections selections : selecList){
            ps = conn.prepareStatement(sql);
            ps.setString(1, selections.getName());
            ps.execute();
        }
        ps.close();
        System.out.println("Selections tábla feltöltve!");
    }
    public void storeCustomers(ArrayList<Customers> custList) throws SQLException{
        conn = DriverManager.getConnection(url, username, password);
        String sql = 
        """
        INSERT INTO customers(customer_name, phone_number)
        VALUES(?,?);        
        """;
        for(Customers customers : custList){
            ps = conn.prepareStatement(sql);
            ps.setString(1, customers.getName());
            ps.setString(2, customers.getPhone_number());
            ps.execute();
        }
        ps.close();
        System.out.println("Customers tábla feltöltve!");
    }
    public void storeEmployees(ArrayList<Employees> empList) throws SQLException{
        conn = DriverManager.getConnection(url, username, password);
        String sql = 
        """
        INSERT INTO employees(employee_name, phone_number, hire_date, salary, position_id)
        VALUES(?,?,?,?,?);        
        """;
        for(Employees employees : empList){
            ps = conn.prepareStatement(sql);
            ps.setString(1, employees.getName());
            ps.setString(2, employees.getPhone_number());
            ps.setDate(3, employees.getHire_date());
            ps.setDouble(4, employees.getSalary());
            ps.setInt(5, employees.getPosition_id());
            ps.execute();
        }
        ps.close();
        System.out.println("Employees tábla feltöltve!");
    }
    public void storeProducts(ArrayList<Products> prodList) throws SQLException{
        conn = DriverManager.getConnection(url, username, password);
        String sql = 
        """
        INSERT INTO products(product_name, amount, price, selection_id, purchaser)
        VALUES(?,?,?,?,?);        
        """;
       for(Products products : prodList){
        ps = conn.prepareStatement(sql);
        ps.setString(1, products.getName());
        ps.setInt(2, products.getAmount());
        ps.setDouble(3, products.getPrice());
        ps.setInt(4, products.getSelection_id());
        ps.setString(5, products.getPurcharser());
        ps.execute();
        }
        ps.close();
        System.out.println("Products tábla feltöltve!");
    }
    
}
