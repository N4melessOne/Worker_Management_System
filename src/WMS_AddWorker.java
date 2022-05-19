import BaseClasses.Worker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

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
                Worker newWorker = new Worker();
                newWorker.setWorkerName(workerNameTb.getText());
                newWorker.setWorkerAddress(addressTb.getText());
                newWorker.setBirthDate(Timestamp.valueOf(birthDateTb.getText()));
                newWorker.setDepartmentId(Integer.parseInt(departmentIdTb.getText()));
                newWorker.setLeader(leaderCb.isSelected());
                newWorker.setMobile(mobileTb.getText());
                newWorker.setEmail(emailTb.getText());
                newWorker.setSalary(Integer.parseInt(salaryTb.getText()));

                Boolean created = SQLHandler.executeInsert(String.format("INSERT INTO workers (workerName,workerAddress,birthDate,departmentId,leader,mobile,email,salary)" +
                        " VALUES (%s,%s,%t,%d,%b,%s,%s,%d)",newWorker.getWorkerName(),newWorker.getWorkerAddress(),newWorker.getBirthDate(),
                        newWorker.getDepartmentId(),newWorker.getLeader() ? 1 : null,newWorker.getMobile(),newWorker.getEmail(),newWorker.getSalary()));

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