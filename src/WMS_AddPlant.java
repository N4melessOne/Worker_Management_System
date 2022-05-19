import BaseClasses.Plant;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WMS_AddPlant extends JFrame{
    private JPanel WMS_AddPlant;
    private JTextField plantNameTb;
    private JTextField plantAddressTb;
    private JTextField revenueTb;
    private JTextField costTb;
    private JButton addBtn;
    private JLabel plantAddressLbl;
    private JLabel plantNameLbl;
    private JLabel revenueLbl;
    private JLabel costLbl;

    public WMS_AddPlant(){
        setContentPane(WMS_AddPlant);
        setTitle("WMS Add Plant");
        setSize(400,300);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean created = false;
                PreparedStatement statement = null;
                try {
                    statement = SQLHandler.connection.prepareStatement("INSERT INTO plants (plantName, plantAddress, revenue, cost) VALUES (?,?,?,?)");

                    statement.setString(1, plantNameTb.getText());
                    statement.setString(2,plantAddressTb.getText());
                    statement.setInt(3,Integer.parseInt(revenueTb.getText()));
                    statement.setInt(4,Integer.parseInt(costTb.getText()));

                    created = SQLHandler.executeInsert(statement);
                } catch (SQLException ex) {
                    //TODO:LOGGING!
                }
                if(created){
                    JOptionPane.showMessageDialog(WMS_AddPlant, "You have successfully created a new plant!");
                }
                else{
                    JOptionPane.showMessageDialog(WMS_AddPlant, "There was a problem with inserting the new plant!"); //TODO:Try to be specific here!
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame WMSAddPlant = new WMS_AddPlant();
        WMSAddPlant.pack();
    }
}
