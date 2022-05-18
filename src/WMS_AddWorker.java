import javax.swing.*;

public class WMS_AddWorker extends JFrame{
    private JPanel WMS_AddWorker;
    private JTextField workerNameTb;
    private JLabel workerNameLbl;
    private JTextField addressTb;
    private JTextField departmentIdTb;
    private JTextField positionTb;
    private JTextField mobileTb;
    private JTextField emailTb;
    private JTextField salaryTb;
    private JTextField textField8;
    private JButton addWorkerBtn;
    private JLabel workerAddressLbl;
    private JLabel birthDateLbl;
    private JLabel departmentIdLbl;
    private JLabel isLeaderLbl;
    private JLabel mobileLbl;
    private JLabel emailLbl;
    private JLabel salaryLbl;
    private JTextField birthDateTb;

    public WMS_AddWorker(){
        setContentPane(WMS_AddWorker);
        setTitle("WMS Add Worker");
        setSize(400,600);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        JFrame WMSAddWorker = new WMS_AddWorker();
        WMSAddWorker.pack();
    }
}