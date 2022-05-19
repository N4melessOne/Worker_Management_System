import BaseClasses.Worker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WMS_AddWorker extends JFrame{
    private JPanel WMS_AddWorker;
    private JTextField workerNameTb;
    private JLabel workerNameLbl;
    private JTextField addressTb;
    private JTextField departmentIdTb;
    private JCheckBox leaderCb;
    private JTextField mobileTb;
    private JTextField emailTb;
    private JTextField salaryTb;
    private JButton addWorkerBtn;
    private JLabel workerAddressLbl;
    private JLabel birthDateLbl;
    private JLabel departmentIdLbl;
    private JLabel mobileLbl;
    private JLabel emailLbl;
    private JLabel salaryLbl;
    private JTextField birthDateTb;
    private JTextField plantIdTb;
    private JLabel plantIdLbl;

    public WMS_AddWorker(){
        setContentPane(WMS_AddWorker);
        setTitle("WMS Add Worker");
        setSize(400,600);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        addWorkerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean created = false;
                PreparedStatement statement = null;
                try {
                    statement = SQLHandler.connection.prepareStatement("INSERT INTO workers (workerName, workerAddress, birthDate, departmentId, leader, mobile, email, salary, plantId) VALUES (?,?,?,?,?,?,?,?,?)");

                    statement.setString(1, workerNameTb.getText());
                    statement.setString(2,addressTb.getText());
                    statement.setDate(3, Date.valueOf(birthDateTb.getText()));
                    statement.setInt(4,Integer.parseInt(departmentIdTb.getText()));
                    statement.setInt(9,Integer.parseInt(plantIdTb.getText()));
                    statement.setBoolean(5,leaderCb.isSelected());
                    statement.setString(6,mobileTb.getText());
                    statement.setString(7,emailTb.getText());
                    statement.setInt(8,Integer.parseInt(salaryTb.getText()));

                    created = SQLHandler.executeInsert(statement);
                } catch (SQLException ex) {
                    //TODO:LOGGING!
                }
                if(created){
                    JOptionPane.showMessageDialog(WMS_AddWorker, "You have successfully created a new worker!");
                    try {
                        WMS_Main.getWorkers();
                    } catch (SQLException ex) {
                        //TODO:Log something.
                    }
                }
                else{
                    JOptionPane.showMessageDialog(WMS_AddWorker, "There was a problem with inserting the new worker!"); //TODO:Try to be specific here!
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame WMSAddWorker = new WMS_AddWorker();
        WMSAddWorker.pack();
    }
}