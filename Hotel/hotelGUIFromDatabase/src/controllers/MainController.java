package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class MainController {
    
    private DataBaseController dbCtr;

    public MainController(){

        dbCtr = new DataBaseController();

        // getRentignsData();
        // getRoomsData();
        // getRentersData();
        // getRentignForRenter(2);
    }
    public void getRentignsData(){

        ArrayList<ArrayList<Object>> rentings = new ArrayList<>();

        rentings = dbCtr.readRentings();

        for(ArrayList<Object> renting : rentings){

            for(Object rtg : renting){

                System.out.print(rtg + " ");
            }
            System.out.println();
        }    
    }
    public void getRoomsData(){
        ArrayList<ArrayList<Object>> rooms = new ArrayList<>();

        rooms = dbCtr.readRooms();

        for(ArrayList<Object> room : rooms){
            for(Object rm : room){
                System.out.print(rm + " ");
            }
            System.out.println();
        }
    }
    public void getRentersData(){
        ArrayList<ArrayList<Object>> renters = new ArrayList<>();

        renters = dbCtr.readRenters();

        for(ArrayList<Object> renter : renters){
            for(Object rnt : renter){
                System.out.print(rnt + " ");
            }
            System.out.println();
        }
    }
    public void addRentersNamesToList(JList<String> renterList){
        ArrayList<ArrayList<Object>> rentersData = dbCtr.readRenters();
        DefaultListModel<String> model = new DefaultListModel<>();
    
        for(ArrayList<Object> renter: rentersData){
            model.addElement(renter.get(1).toString());
        }
        renterList.setModel(model);
    }
    public List<Object> getRenter(String renterName){
        ArrayList<ArrayList<Object>> renters = dbCtr.readRenters();
        List<Object> selectRenter = new ArrayList<>();

        for(ArrayList<Object> renter : renters){
            if(renter.get(1).equals(renterName)){
                selectRenter = renter;
                break;
            }
        }
        return selectRenter;     
    }
    public int getRenterIdByName(String renterName) {
        ArrayList<ArrayList<Object>> rentersData = dbCtr.readRenters();
        for(ArrayList<Object> renter: rentersData) {
            if(renter.get(1).toString().equals(renterName)) {
                return Integer.parseInt(renter.get(0).toString());
            }
        }
        return -1; 
    }
    public void getRentignForRenter(int renterId){
        ArrayList<ArrayList<Object>> rentingsForRenter = dbCtr.readRentingForRenter(renterId);
        for(ArrayList<Object> renting : rentingsForRenter){
            for(Object rtg: renting){
                System.out.print(rtg + " ");
            }
            System.out.println();
        }
    }
    public ArrayList<ArrayList<Object>> getRentingForRenterById(int renterId){
        return dbCtr.readRentingForRenter(renterId);
    } 
}
