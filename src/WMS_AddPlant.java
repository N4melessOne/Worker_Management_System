import BaseClasses.Plant;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                Plant newPlant = new Plant();
                newPlant.setPlantName(plantNameTb.getText());
                newPlant.setPlantAddress(plantAddressTb.getText());
                newPlant.setRevenue(Integer.parseInt(revenueTb.getText()));
                newPlant.setCost(Integer.parseInt(costTb.getText()));

                Boolean created = SQLHandler.executeInsert(String.format("INSERT INTO plants (plantName,plantAddress,revenue,cost)" +
                                " VALUES (%s,%s, %d,%d)",newPlant.getPlantName(),newPlant.getPlantAddress(), newPlant.getRevenue(), newPlant.getCost()));

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
