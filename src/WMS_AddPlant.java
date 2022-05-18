import javax.swing.*;

public class WMS_AddPlant extends JFrame{
    private JPanel WMS_AddPlant;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    public WMS_AddPlant(){
        setContentPane(WMS_AddPlant);
        setTitle("WMS Add Plant");
        setSize(640, 480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        JFrame WMSAddPlant = new WMS_AddPlant();
        WMSAddPlant.pack();
    }
}
