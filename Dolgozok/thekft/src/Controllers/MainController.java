package Controllers;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

import Readers.ReadFile;
import SetDatas.FillDatabase;
import Models.Customers;
import Models.Employees;
import Models.Positions;
import Models.Products;
import Models.Selections;

public class MainController {
    ReadFile reader = new ReadFile();
    FillDatabase filler = new FillDatabase();

    public MainController() throws FileNotFoundException, SQLException{
        Positions();
        Selections();
        Customers();
        Employees();
        Products();
    }
    private void Positions() throws FileNotFoundException, SQLException{
        ArrayList<Positions> posiList = reader.readPositions("./files/positions.csv");
        filler.storePositions(posiList);
        StringBuilder sb = new StringBuilder();
        for(Positions positions : posiList){
            sb.append(positions.getName()).append("\n");
        }
        System.out.println(sb.toString());
    }
    private void Selections() throws FileNotFoundException, SQLException{
        ArrayList<Selections> selecList = reader.readSelections("./files/selections.csv");
        filler.storeSelections(selecList);
        StringBuilder sb = new StringBuilder();
        for(Selections selections : selecList){
            sb.append(selections.getName()).append("\n");
        }
        System.out.println(sb.toString());
    }
    private void Customers() throws FileNotFoundException, SQLException{
        ArrayList<Customers> custList  = reader.readCustomers("./files/customers.csv");
        filler.storeCustomers(custList);
        StringBuilder sb = new StringBuilder();
        for(Customers customers : custList){
            sb.append(customers.getName()).append(".")
            .append(customers.getPhone_number()).append("\n");
        }
        System.out.println(sb.toString());
    }
    private void Employees() throws FileNotFoundException, SQLException{
        ArrayList<Employees> empList = reader.readEmployees("./files/employees.csv");
        filler.storeEmployees(empList);
        StringBuilder sb = new StringBuilder();
        for(Employees employees : empList){
            sb.append(employees.getName()).append(".")
            .append(employees.getPhone_number()).append(".")
            .append(employees.getHire_date()).append(".")
            .append(employees.getSalary()).append(".")
            .append(employees.getPosition_id()).append("\n");
        }
        System.out.println(sb.toString());
    }
    private void Products() throws FileNotFoundException, SQLException{
        ArrayList<Products> prodList = reader.readProducts("./files/products.csv");
        filler.storeProducts(prodList);
        StringBuilder sb = new StringBuilder();
        for(Products products : prodList){
            sb.append(products.getName()).append(".")
            .append(products.getAmount()).append(".")
            .append(products.getPrice()).append(".")
            .append(products.getSelection_id()).append("\n");
            
        }
    }
}
