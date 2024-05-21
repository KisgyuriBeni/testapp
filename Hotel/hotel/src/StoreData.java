import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoreData {
    
    String username = "root";
    String password = "";
    String url = "jdbc:mariadb://localhost:3306/hotel";

    public void storeRooms(ArrayList<Szobak> szobakList) throws SQLException{

        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = 
        """
        INSERT INTO rooms(id, szoba_szam, szoba_merete, agyak_szama, terasz, haziallat)
        VALUES(?,?,?,?,?,?);       
        """;
        for(Szobak szobak : szobakList){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, szobak.id);
            ps.setString(2, szobak.szoba_szam);
            ps.setInt(3, szobak.szoba_meret);
            ps.setInt(4, szobak.agyak_szama);
            ps.setBoolean(5, szobak.terasz);
            ps.setBoolean(6, szobak.haziallat);
            ps.execute();
        }
        System.out.println("Sikeres feltöltés!");
        conn.close();
    }
    public void storeRenters(ArrayList<Foglalok> foglalokList) throws SQLException{

        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = 
        """
        INSERT INTO renters(id, nev, szuletesi_datum)
        VALUES(?,?,?);       
        """;
        for(Foglalok foglalok : foglalokList){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, foglalok.id);
            ps.setString(2, foglalok.nev);
            ps.setDate(3, foglalok.szuletesi_datum);
            ps.execute();
        }
        System.out.println("Sikeres feltöltés!");
        conn.close();
    }
    public void storeRentings(ArrayList<Foglalasok> foglalasokList) throws SQLException{

        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = 
        """
        INSERT INTO rentings(id, szoba_id, foglalo_id, foglalas_eleje, foglalas_vege)
        VALUES(?,?,?,?,?);       
        """;
        for(Foglalasok foglalasok : foglalasokList){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, foglalasok.id);
            ps.setInt(2, foglalasok.szoba_id);
            ps.setInt(3, foglalasok.foglalo_id);
            ps.setDate(4, foglalasok.foglalas_eleje);
            ps.setDate(5, foglalasok.foglalas_vege);
            ps.execute();
        }
        System.out.println("Sikeres feltöltés!");
        conn.close();
    }
}
