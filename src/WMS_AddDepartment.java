import javax.swing.*;

public class WMS_AddDepartment extends JFrame{
    private JPanel WMS_AddDepartment;
    private JLabel testLbl;

    public WMS_AddDepartment(){
        setContentPane(WMS_AddDepartment);
        setTitle("WMS Add Department");
        setSize(640, 480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        JFrame WMSAddDepartment = new WMS_AddDepartment();
        WMSAddDepartment.pack();
    }
}
