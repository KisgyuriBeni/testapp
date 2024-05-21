import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    
    public ArrayList<Foglalok> fileReader(String path) throws FileNotFoundException{
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
}
