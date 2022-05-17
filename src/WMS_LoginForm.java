import javax.swing.*;

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

    }

    public static void main(String[] args) {
        JFrame WMSLoginForm = new WMS_LoginForm();
        WMSLoginForm.pack();
    }
}
