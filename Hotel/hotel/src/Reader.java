import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    
    public ArrayList<Szobak> readSzobak(String path) throws FileNotFoundException{
        ArrayList<Szobak> szobakList = new ArrayList<>();

        File file = new File(path);
        Scanner sc = new Scanner(file);
        
        sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineArray = line.split(";");

            Szobak szobak = new Szobak();

            szobak.id = Integer.parseInt(lineArray[0]);
            szobak.szoba_szam = lineArray[1];
            szobak.szoba_meret = Integer.parseInt(lineArray[2]);
            szobak.agyak_szama = Integer.parseInt(lineArray[3]);
            szobak.terasz = Boolean.parseBoolean(lineArray[4]);
            szobak.haziallat = Boolean.parseBoolean(lineArray[5]);

            szobakList.add(szobak);
        }
        sc.close();
        return szobakList;
    }
    public ArrayList<Foglalok> readFoglalok(String path) throws FileNotFoundException, ParseException{
        ArrayList<Foglalok> foglalokList = new ArrayList<>();

        File file = new File(path);
        Scanner sc = new Scanner(file);

        sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineArray = line.split(";");

            Foglalok foglalok = new Foglalok();

            foglalok.id = Integer.parseInt(lineArray[0]);
            foglalok.nev = lineArray[1];
            foglalok.setSzuletesi_datum(lineArray[2]);

            foglalokList.add(foglalok);
        }
        sc.close();
        return foglalokList;
    }
    public ArrayList<Foglalasok> readFoglalasok(String path) throws FileNotFoundException{
        ArrayList<Foglalasok> foglalasokList = new ArrayList<>();

        File file = new File(path);
        Scanner sc = new Scanner(file);

        sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineArray = line.split(";");

            Foglalasok foglalasok = new Foglalasok();

            foglalasok.id = Integer.parseInt(lineArray[0]);
            foglalasok.szoba_id = Integer.parseInt(lineArray[1]);
            foglalasok.foglalo_id = Integer.parseInt(lineArray[2]);
            foglalasok.setFoglalas_eleje(lineArray[3]);
            foglalasok.setFoglalas_vege(lineArray[4]);

            foglalasokList.add(foglalasok);
        }
        sc.close();
        return foglalasokList;
    }
}
