import javax.swing.*;

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
    }

    public static void main(String[] args) {
        JFrame WMSDeleteDepartment = new WMS_DeleteDepartment();
        WMSDeleteDepartment.pack();
    }
}