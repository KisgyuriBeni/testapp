package Readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import Models.Customers;
import Models.Employees;
import Models.Positions;
import Models.Products;
import Models.Selections;

public class ReadFile {
    
    public ArrayList<Positions> readPositions(String path) throws FileNotFoundException{

        ArrayList<Positions> posiList = new ArrayList<>();

        File file = new File(path);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineArray = line.split(";");

            String name = lineArray[0];

            Positions positions = new Positions(name);
            posiList.add(positions);
            
        }
        sc.close();
        return posiList;
    }
    public ArrayList<Selections> readSelections(String path) throws FileNotFoundException{

        ArrayList<Selections> selectList = new ArrayList<>();

        File file = new File(path);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineArray = line.split(";");

            String name = lineArray[0];

            Selections selections = new Selections(name);
            selectList.add(selections);
            
        }
        sc.close();
        return selectList;
    }
    public ArrayList<Employees> readEmployees(String path) throws FileNotFoundException{

        ArrayList<Employees> empList = new ArrayList<>();

        File file = new File(path);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineArray = line.split(";");

            String name = lineArray[0];
            String phone_number = lineArray[1];
            Date hire_date = Date.valueOf(lineArray[2]);
            Double salary = Double.parseDouble(lineArray[3]);
            Integer position_id = Integer.parseInt(lineArray[4]);

            Employees employees = new Employees(name, phone_number, hire_date, salary, position_id);
            empList.add(employees);
        }
        sc.close();
        return empList;
    }
    public ArrayList<Products> readProducts(String path) throws FileNotFoundException{

        ArrayList<Products> prodList = new ArrayList<>();

        File file = new File(path);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineArray = line.split(";");

            String name = lineArray[0];
            Integer amount = Integer.parseInt(lineArray[1]);
            Double price = Double.parseDouble(lineArray[2]);
            Integer type_id = Integer.parseInt(lineArray[3]);
            String purcharser = lineArray[4];

            Products products = new Products(name, price, amount, type_id, purcharser);
            prodList.add(products);
        }
        sc.close();
        return prodList;
    }
    
    public ArrayList<Customers> readCustomers(String path) throws FileNotFoundException{

        ArrayList<Customers> custList = new ArrayList<>();

        File file = new File(path);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineArray = line.split(";");

            String name = lineArray[0];
            String phone_number = lineArray[1];
            
            Customers customers = new Customers(name, phone_number);
            custList.add(customers);
        }
        sc.close();
        return custList;
    }
    
    
}
