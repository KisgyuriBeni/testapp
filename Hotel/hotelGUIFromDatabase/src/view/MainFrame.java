package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controllers.MainController;

public class MainFrame extends JFrame{
    
    private JPanel basePanel;
    private JPanel selectPanel;
    private JPanel rentingPanel;

    private JPanel northPanel;    
    private JPanel southPanel;    
    private JPanel eastPanel;    
    private JPanel westPanel;    
    private JPanel centerPanel;
    private JLabel selectLabel;    
    private JLabel rentingLabel; 

    private JList<String> renterList;
    private JTable rentingTable;

    private MainController mainController;

    public MainFrame(){
        mainController = new MainController();
        InitComponent();
    }
    public void InitComponent(){

        basePanel = new JPanel();
        selectPanel = new JPanel();
        rentingPanel = new JPanel();
        selectLabel = new JLabel("Foglalók: ");
        rentingLabel = new JLabel("Foglalások és szobák: ");
    
        renterList = new JList<>();
        mainController.addRentersNamesToList(renterList);
        renterList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedRenter = renterList.getSelectedValue();
                int renterId = mainController.getRenterIdByName(selectedRenter);
                ArrayList<ArrayList<Object>> rentings = mainController.getRentingForRenterById(renterId);
                
                rentingPanel.removeAll();
                
                Object[][] data = new Object[rentings.size()][5];
                for (int i = 0; i < rentings.size(); i++) {
                    data[i] = rentings.get(i).toArray();
                }
                String[] columnsName = {"Foglalsás eleje", "Foglalás vége", "Név", "Szoba szám", "Ágyak száma"};
                
                rentingTable = new JTable(data, columnsName);
                rentingPanel.add(new JScrollPane(rentingTable), BorderLayout.CENTER);
                rentingPanel.revalidate();
                rentingTable.repaint();
            }
        });
    
        northPanel = new JPanel();
        southPanel = new JPanel();
        eastPanel = new JPanel();
        westPanel = new JPanel();
        centerPanel = new JPanel();

        northPanel.add(rentingLabel);
        centerPanel.setLayout(new BorderLayout());
    
        basePanel.setLayout(new GridLayout(0,2));
        rentingPanel.setLayout(new BorderLayout());

        rentingPanel.add(northPanel, BorderLayout.NORTH);
        rentingPanel.add(southPanel, BorderLayout.SOUTH);
        rentingPanel.add(eastPanel, BorderLayout.EAST);
        rentingPanel.add(westPanel, BorderLayout.WEST);
    
        selectPanel.add(selectLabel);
        selectPanel.add(renterList);
    
        
        
        basePanel.add(selectPanel);
        basePanel.add(rentingPanel);
    
        add(basePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Hotel GUI");
        setSize(500,600);
        setVisible(true);
    }

}


