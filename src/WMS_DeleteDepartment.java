import javax.swing.*;

public class WMS_DeleteDepartment extends JFrame{
    private JPanel WMS_DeleteDepartment;
    private JLabel testLbl;

    public WMS_DeleteDepartment(){
        setContentPane(WMS_DeleteDepartment);
        setTitle("WMS Delete Department");
        setSize(640, 480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame WMSDeleteDepartment = new WMS_DeleteDepartment();
        WMSDeleteDepartment.pack();
    }
}