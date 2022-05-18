import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WMS_LoginForm extends JFrame{
    private JPanel WMS_LoginForm;
    private JTextField idTb;
    private JLabel idLbl;
    private JButton idOkBtn;


    public WMS_LoginForm(){
        setContentPane(WMS_LoginForm);
        setTitle("WMS Login As Leader");
        setLocationRelativeTo(null);
        setSize(320,200);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        idOkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    int temp;
                    if (Helper.tryParse(idTb.getText()) == true) {
                        temp = Integer.parseInt(idTb.getText());
                        ResultSet result = SQLHandler.execute(String.format("SELECT leader FROM workers WHERE workerId=%d", temp));
                        String leader = result.getString(6);
                        JOptionPane.showMessageDialog(WMS_LoginForm, leader);
                    }
                }catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
    }

    public static void main(String[] args) {
        JFrame WMSLoginForm = new WMS_LoginForm();
        WMSLoginForm.pack();
    }
}
