import javax.swing.*;

public class WMS_AddDepartment extends JFrame{
    private JPanel WMS_AddDepartment;
    private JTextField departmentNameTb;
    private JTextField maxWorkersTb;
    private JButton addDepartmentBtn;
    private JLabel departmentNameIdLbl;
    private JLabel maxWorkerLbl;

    public WMS_AddDepartment(){
        setContentPane(WMS_AddDepartment);
        setTitle("WMS Add Department");
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        JFrame WMSAddDepartment = new WMS_AddDepartment();
        WMSAddDepartment.pack();
    }
}
