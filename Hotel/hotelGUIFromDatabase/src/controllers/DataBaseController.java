package controllers;

import java.sql.Connection;
import java.util.ArrayList;


import models.Connect;
import models.SqlRunner;

public class DataBaseController {
    private SqlRunner sqlR;
    private Connection conn;

    public DataBaseController(){
        getConnect();
    }
    private void getConnect(){
        Connect connect = new Connect("hotel", "root", "");
        connect.Connecting();
        conn = connect.getConnection();
    }
    public ArrayList<ArrayList<Object>> readRentings(){

        ArrayList<ArrayList<Object>> rentings = new ArrayList<>();

        sqlR = new SqlRunner("get");
        rentings = sqlR.getRentigns(conn);

        return rentings;
        
    }
    public ArrayList<ArrayList<Object>> readRooms(){
        ArrayList<ArrayList<Object>> rooms = new ArrayList<>();

        sqlR = new SqlRunner("getRooms");
        rooms = sqlR.getRooms(conn);
        return rooms;
    }
    public ArrayList<ArrayList<Object>> readRenters(){
        ArrayList<ArrayList<Object>> renters = new ArrayList<>();

        sqlR = new SqlRunner("getRenters");
        renters = sqlR.getRenters(conn);
        return renters;
    }
    public ArrayList<ArrayList<Object>> readRentingForRenter(int renterId){
        ArrayList<ArrayList<Object>> rentingsForRenter = new ArrayList<>();

        sqlR = new SqlRunner("getRentingsById");
        rentingsForRenter = sqlR.getRentingsForRenter(conn, renterId);

        return rentingsForRenter;
    }
    

}
