import javax.swing.*;

public class WMS_AddPlant extends JFrame{
    private JPanel WMS_AddPlant;
    private JTextField plantNameTb;
    private JTextField plantAddressTb;
    private JTextField revenueTb;
    private JTextField costTb;
    private JButton addBtn;
    private JLabel plantAddresslbl;
    private JLabel plantNameLbl;
    private JLabel revenueLbl;
    private JLabel costLbl;

    public WMS_AddPlant(){
        setContentPane(WMS_AddPlant);
        setTitle("WMS Add Plant");
        setSize(400,300);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        JFrame WMSAddPlant = new WMS_AddPlant();
        WMSAddPlant.pack();
    }
}
