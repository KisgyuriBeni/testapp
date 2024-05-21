import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Getdata {
    
    public ArrayList<String> getEmployees(){
        ArrayList<String> datas = new ArrayList<>();
        String user = "root";
        String password = "";
        String url = "jdbc:mariadb://localhost:3306/vegyesbolt";
        String sql = 
        """
        SELECT * FROM employees;        
        """;
        try (Connection conn = DriverManager.getConnection(url, user, password)){
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                Integer id = res.getInt("id");
                String name = res.getString("employee_name");
                String phone = res.getString("phone_number");
                Date hiredate = res.getDate("hire_date");
                Double salary = res.getDouble("salary");
                Integer posision_id = res.getInt("position_id");

                StringBuilder sb = new StringBuilder();
                sb.append(id).append(", ")
                .append(name).append(", ")
                .append(phone).append(", ")
                .append(hiredate).append(", ")
                .append(salary).append(", ")
                .append(posision_id).append("\n");

                datas.add(sb.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datas;
    }
    public ArrayList<String> getEmployeeNames(){
        ArrayList<String> employeeNames = new ArrayList<>();
        String user = "root";
        String password = "";
        String url = "jdbc:mariadb://localhost:3306/vegyesbolt";
        String sql = "SELECT employees.employee_name FROM employees";
        try (Connection conn = DriverManager.getConnection(url, user, password)){
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                String name = res.getString("employee_name");
                employeeNames.add(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeNames;
    }
    public ArrayList<String> getEmployeesData(String employeename){
        ArrayList<String> empdata = new ArrayList<>();
        String user = "root";
        String password = "";
        String url = "jdbc:mariadb://localhost:3306/vegyesbolt";

        String sql = 
        """
        SELECT employees.id, employees.employee_name, employees.phone_number, employees.hire_date, employees.salary, positions.position_name  
        FROM employees
        INNER JOIN positions ON employees.position_id = positions.id
        WHERE employees.employee_name = ?        
        """;

        try (Connection conn = DriverManager.getConnection(url, user, password)){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, employeename);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("employee_name");
                String phone = rs.getString("phone_number");
                Date hiredate = rs.getDate("hire_date");
                Double salary = rs.getDouble("salary");
                String posision = rs.getString("positions.position_name");

                StringBuilder sb = new StringBuilder();
                sb.append("Az alkalmazott adatai:\n")
              .append("ID: ").append(id).append("\n")
              .append("Név: ").append(name).append("\n")
              .append("Telefonszám: ").append(phone).append("\n")
              .append("Belépés dátuma: ").append(hiredate).append("\n")
              .append("Fizetés: ").append(salary).append("\n")
              .append("Pozíció ID: ").append(posision).append("\n");

                empdata.add(sb.toString());
            }else{
                empdata.add("Nincs ilyen nevű alkalmazott az adatbázisban.");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empdata;
    }
}
