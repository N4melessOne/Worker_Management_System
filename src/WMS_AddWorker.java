import BaseClasses.Worker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WMS_AddWorker extends JFrame{
    private JPanel WMS_AddWorker;
    private JTextField workerNameTb;
    private JLabel workerNameLbl;
    private JTextField addressTb;
    private JTextField departmentIdTb;
    private JTextField positionTb;
    private JTextField mobileTb;
    private JTextField emailTb;
    private JTextField salaryTb;
    private JButton addWorkerBtn;
    private JLabel workerAddressLbl;
    private JLabel birthDateLbl;
    private JLabel departmentIdLbl;
    private JLabel isLeaderLbl;
    private JLabel mobileLbl;
    private JLabel emailLbl;
    private JLabel salaryLbl;
    private JTextField birthDateTb;

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
                //TODO:Try to validate all the information, if there's time for it!
                String[] data = { workerNameTb.getText(), addressTb.getText(), birthDateTb.getText(),
                        positionTb.getText(), departmentIdTb.getText(), mobileTb.getText(), emailTb.getText(), salaryTb.getText() };
                Boolean created = SQLHandler.executeInsert(String.format("INSERT INTO workers (workerName,workerAddress,birthDate,departmentId,leader,mobile,email,salary)" +
                        " VALUES (%s,%s,%s,%s,%s,%s,%s,%s)",data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7]));

                //TODO:Doesn't work, so should check it out!
                if(created){
                    JOptionPane.showMessageDialog(WMS_AddWorker, "You have successfully created a new worker!");
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