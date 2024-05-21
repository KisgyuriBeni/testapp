import java.sql.Date;

public class Foglalasok {
    
    int id;
    int szoba_id;
    int foglalo_id;
    Date foglalas_eleje;
    Date foglalas_vege;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getSzoba_id() {
        return szoba_id;
    }
    public void setSzoba_id(int szoba_id) {
        this.szoba_id = szoba_id;
    }
    public int getFoglalo_id() {
        return foglalo_id;
    }
    public void setFoglalo_id(int foglalo_id) {
        this.foglalo_id = foglalo_id;
    }
    public Date getFoglalas_eleje() {
        return foglalas_eleje;
    }
    public void setFoglalas_eleje(String foglalas_eleje) {
        this.foglalas_eleje = Date.valueOf(foglalas_eleje);
    }
    public Date getFoglalas_vege() {
        return foglalas_vege;
    }
    public void setFoglalas_vege(String foglalas_vege) {
        this.foglalas_vege = Date.valueOf(foglalas_vege);
    }

    
}
