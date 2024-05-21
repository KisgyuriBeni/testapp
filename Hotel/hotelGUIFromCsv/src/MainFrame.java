import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame {
    
    JPanel basepanel;
    JPanel panel1;
    JPanel panel2;

    JPanel panelNorth;
    JPanel panelSouth;
    JPanel panelWest;
    JPanel panelEast;
    JPanel panelCenter;

    JTable table;
    JLabel mainLabel;
    JComboBox<Foglalok> comboBox;

    MainFrame(){
        InitComponent();
    }
    public void InitComponent(){

        basepanel = new JPanel();
        basepanel.setLayout(new GridLayout(2,0));

        panel1 = new JPanel();
        panel2 = new JPanel();
        mainLabel = new JLabel("Szoba Foglalások");
        comboBox = new JComboBox<>();
        table = new JTable();

        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelEast = new JPanel();
        panelWest = new JPanel();
        panelCenter = new JPanel();

        panel1.setLayout(new BorderLayout());
        panel1.add(panelNorth, BorderLayout.NORTH);
        panel1.add(panelSouth, BorderLayout.SOUTH);
        panel1.add(panelEast, BorderLayout.EAST);
        panel1.add(panelWest, BorderLayout.WEST);
        panel1.add(panelCenter, BorderLayout.CENTER);

        panelNorth.add(mainLabel);
        panelCenter.add(comboBox);

        ArrayList<Foglalok> foglalokList = new ArrayList<>();
        DisplayDataInTable(foglalokList);

        panel2.add(new JScrollPane(table));

        basepanel.add(panel1);
        basepanel.add(panel2);

        add(basepanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,600);
        setTitle("Foglalások");
        setResizable(false);
        setVisible(true);
    }

    public void DisplayDataInTable(ArrayList<Foglalok> foglalokList){
        Reader reader = new Reader();
        try {
        foglalokList = reader.fileReader("foglalok.csv");
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        }
        String[] columnNames = {"Id", "Név", "Születési dátum"};
        String[][] data = new String[foglalokList.size()][3];
        
        for (int i = 0; i < foglalokList.size(); i++) {
            Foglalok foglalok = foglalokList.get(i);
            data[i][0] = String.valueOf(foglalok.id);
            data[i][1] = foglalok.getNev();
            data[i][2] = foglalok.getSzuletesi_datum().toString();
        }
        System.out.println(data);
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table.setModel(model);
    }
}
