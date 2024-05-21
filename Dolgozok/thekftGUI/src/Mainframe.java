import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Mainframe extends JFrame{
    
    JPanel basepanel;
    JList<String> empList;
    JTextArea textArea;
    JScrollPane textJScrollPane;
    JScrollPane scrollPane;
    Getdata dataprovider;

    public Mainframe(){
        Initcomponent();
    }
    private void Initcomponent(){
        basepanel = new JPanel();
        dataprovider = new Getdata();

        empList = new JList<>();
        scrollPane = new JScrollPane(empList);

        empList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    String selectedName = empList.getSelectedValue();
                    displayselectedname(selectedName);
                }
            }
            
        });

        updateEmployeesList();

        basepanel.add(scrollPane);

        textArea = new JTextArea(20,40);
        textArea.setEditable(false);
        textJScrollPane = new JScrollPane(textArea);
        basepanel.add(textJScrollPane);

        add(basepanel);
        setTitle("Alkalmazottak");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void updateEmployeesList(){
        DefaultListModel<String> model = new DefaultListModel<>();
        ArrayList<String> empname = dataprovider.getEmployeeNames();
        for(String name : empname){
            model.addElement(name);
        }
        empList.setModel(model);
    }
    private void displayselectedname( String name ){
        if(name != null){
            System.out.println(name);
            ArrayList<String> empdata = dataprovider.getEmployeesData(name);
            StringBuilder sb = new StringBuilder();
            for(String data : empdata){
                sb.append(data).append("\n");
            }
            textArea.setText(sb.toString());
        }
    }
}