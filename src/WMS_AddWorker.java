import javax.swing.*;

public class WMS_AddWorker extends JFrame{
    private JPanel WMS_AddWorker;
    private JTextField workerNameTb;
    private JLabel workerNameLbl;

    public WMS_AddWorker(){
        setContentPane(WMS_AddWorker);
        setTitle("WMS Add Worker");
        setLocationRelativeTo(null);
        setSize(400,600);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame WMSAddWorker = new WMS_AddWorker();
        WMSAddWorker.pack();
    }
}