import BaseClasses.Department;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                Department newDepartment =  new Department();
                newDepartment.setDepartmentName(departmentNameTb.getText());
                newDepartment.setMaxWorkers(Integer.parseInt(maxWorkersTb.getText()));

                Boolean created =SQLHandler.executeInsert(String.format("INSERT INTO department (departmentName,maxWorkers)" +
                        " VALUES (%s, %d)",newDepartment.getDepartmentName(),newDepartment.getMaxWorkers()));
                if(created){
                    JOptionPane.showMessageDialog(WMS_AddDepartment, "You have successfully created a new plant!");
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
