import javax.swing.*;
import java.awt.*;

public class WMS_LoginForm extends JFrame{
    private JPanel WMS_LoginForm;
    private JTextField textField1;
    private JLabel idLbl;
    private JButton button1;

    public WMS_LoginForm(){
        setContentPane(WMS_LoginForm);
        setTitle("WMS Login As Leader");
        //Dimension dimension = new Dimension(320,240);
        //setMaximumSize(dimension);
        setLocationRelativeTo(null);
        setSize(320,200);
        setResizable(false);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        JFrame WMSLoginForm = new WMS_LoginForm();
        WMSLoginForm.pack();
    }
}
