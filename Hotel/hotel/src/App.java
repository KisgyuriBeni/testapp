import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();
        StoreData storeData = new StoreData();
        ArrayList<Szobak> szobakList = reader.readSzobak("szobak.csv");
        storeData.storeRooms(szobakList);
        // for(Szobak szobak : szobakList){
        //     System.out.println(szobak.szoba_szam);ellenőrzi a listába kerülését az adatoknak
        // }
        ArrayList<Foglalok> foglalokList = reader.readFoglalok("foglalok.csv");
        storeData.storeRenters(foglalokList);

        ArrayList<Foglalasok> foglalasokList = reader.readFoglalasok("foglalasok.csv");
        storeData.storeRentings(foglalasokList);

    }
}
