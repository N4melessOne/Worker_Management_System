import BaseClasses.Department;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WMS_AddDepartment extends JFrame{
    private JPanel WMS_AddDepartment;
    private JTextField departmentNameTb;
    private JTextField maxWorkersTb;
    private JButton addDepartmentBtn;
    private JLabel departmentNameIdLbl;
    private JLabel maxWorkerLbl;

    public WMS_AddDepartment(){
        setContentPane(WMS_AddDepartment);
        setTitle("WMS Add Department");
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        addDepartmentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean created = false;
                try {
                    PreparedStatement statement = SQLHandler.connection.prepareStatement("INSERT INTO department (departmentName, maxWorkers) VALUES (?, ?)");
                    statement.setString(1, departmentNameTb.getText());
                    statement.setInt(2,Integer.parseInt(maxWorkersTb.getText()));
                    created = SQLHandler.executeInsert(statement);
                } catch (SQLException ex) {
                    //TODO:Log!!!
                }
                if(created){
                    JOptionPane.showMessageDialog(WMS_AddDepartment, "You have successfully created a new plant!");//TODO:LOG!
                }
                else{
                    JOptionPane.showMessageDialog(WMS_AddDepartment, "There was a problem with inserting the new plant!"); //TODO:Try to be specific here!
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame WMSAddDepartment = new WMS_AddDepartment();
        WMSAddDepartment.pack();
    }
}
