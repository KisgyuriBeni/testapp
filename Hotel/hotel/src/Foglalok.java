import java.sql.Date;
import java.text.ParseException;

public class Foglalok {
    
    int id;
    String nev;
    Date szuletesi_datum;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNev() {
        return nev;
    }
    public void setNev(String nev) {
        this.nev = nev;
    }
    public Date getSzuletesi_datum() {
        return szuletesi_datum;
    }
    public void setSzuletesi_datum(String szuletesi_datum) throws ParseException {
        this.szuletesi_datum = Date.valueOf(szuletesi_datum);
    }

    
}
