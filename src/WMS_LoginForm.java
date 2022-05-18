import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        idOkBtn.setEnabled(false);

        idOkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int temp;
                if (Helper.tryParse(idTb.getText()) == true){
                    temp =Integer.parseInt(idTb.getText());
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame WMSLoginForm = new WMS_LoginForm();
        WMSLoginForm.pack();
    }
}
