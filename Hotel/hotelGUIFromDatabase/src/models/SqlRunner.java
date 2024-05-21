package models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SqlRunner {
    private String fileName;

    public SqlRunner(String fileName){
        this.fileName = "sql/" + fileName + ".sql";
        getSql();
    }   
    private String[] getSql(){
        String[] sql = null;
        Path filePath = Path.of(fileName);

        try {
            String content = Files.readString(filePath);
            sql = content.split(";");
        } catch (IOException e) {
            System.out.println("Hiba a beolvasás során!");
        }
        return sql;
    }
    public ArrayList<ArrayList<Object>> getRentigns(Connection conn){
        ArrayList<ArrayList<Object>> rentings = new ArrayList<>();
        String[] sql = getSql();

        PreparedStatement pstmt = null;
        ResultSet res = null;
        try {
            pstmt = conn.prepareStatement(sql[0]);
            res = pstmt.executeQuery();
            while (res.next()) {
                ArrayList<Object> renting = new ArrayList<>();
                renting.add(res.getObject(1));
                renting.add(res.getObject(2));
                renting.add(res.getObject(3));
                renting.add(res.getObject(4));

                rentings.add(renting);
            }
        } catch (SQLException e) {
            System.out.println("Hiba az olvasás során!");
        }
        return rentings;
    }
    public ArrayList<ArrayList<Object>> getRooms(Connection conn){
        ArrayList<ArrayList<Object>> rooms = new ArrayList<>();
        String[] sql = getSql();

        PreparedStatement pstmt = null;
        ResultSet res = null;
        try {
            pstmt = conn.prepareStatement(sql[0]);
            res = pstmt.executeQuery();
            while (res.next()) {
                ArrayList<Object> room = new ArrayList<>();
                room.add(res.getObject(1));
                room.add(res.getObject(3));
                room.add(res.getObject(4));
                room.add(res.getObject(5));
                room.add(res.getObject(6));

                rooms.add(room);
            }
        } catch (SQLException e) {
            System.out.println("Hiba az olvasás során!");
        }
        return rooms;
    }
    public ArrayList<ArrayList<Object>> getRenters(Connection conn){
        ArrayList<ArrayList<Object>> renters = new ArrayList<>();
        String[] sql = getSql();

        PreparedStatement pstmt = null;
        ResultSet res = null;
        try {
            pstmt = conn.prepareStatement(sql[0]);
            res = pstmt.executeQuery();
            while (res.next()) {
                ArrayList<Object> renter = new ArrayList<>();
                renter.add(res.getObject(1));
                renter.add(res.getObject(2));
                renter.add(res.getObject(3));
                renters.add(renter);
            }
        } catch (SQLException e) {
            System.out.println("Hiba az olvasás során!");
        }
        return renters;
    }
    public ArrayList<ArrayList<Object>> getRentingsForRenter(Connection conn, int renterId){
        ArrayList<ArrayList<Object>> rentingsForRenter = new ArrayList<>();
        String[] sql = getSql();
        PreparedStatement pstmt = null;
        ResultSet res = null;

        try {
            pstmt = conn.prepareStatement(sql[0]);
            pstmt.setInt(1, renterId);
            res = pstmt.executeQuery();
            while (res.next()) {
                ArrayList<Object> renting = new ArrayList<>();
                renting.add(res.getObject("foglalas_eleje"));
                renting.add(res.getObject("foglalas_vege"));
                renting.add(res.getObject("nev"));
                renting.add(res.getObject("szoba_szam"));
                renting.add(res.getObject("agyak_szama"));

                rentingsForRenter.add(renting);
            }
        } catch (Exception e) {
            System.out.println("Hiba az olvasás során!");
        }
        return rentingsForRenter;
    }

    
}
