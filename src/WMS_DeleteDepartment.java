import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WMS_DeleteDepartment extends JFrame{
    private JPanel WMS_DeleteDepartment;
    private JTextField idTb;
    private JButton deleteBtn;
    private JLabel idLbl;

    public WMS_DeleteDepartment(){
        setContentPane(WMS_DeleteDepartment);
        setTitle("WMS Login As Leader");
        setLocationRelativeTo(null);
        setSize(320,200);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int temp;
                if (Helper.tryParse(idTb.getText()) == true) {
                    temp = Integer.parseInt(idTb.getText());
                    Boolean deleted = SQLHandler.executeDelete(String.format("DELETE FROM department WHERE departmentId=%d", temp));

                    if(deleted){
                        JOptionPane.showMessageDialog(WMS_DeleteDepartment, String.format("You have successfully deleted the %d. department.", temp));
                        dispose();
                    }
                    else
                        JOptionPane.showMessageDialog(WMS_DeleteDepartment, String.format("There is no department, with the id of %d.", temp));
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame WMSDeleteDepartment = new WMS_DeleteDepartment();
        WMSDeleteDepartment.pack();
    }
}