import javax.swing.*;

public class WMS_AddWorker extends JFrame{
    private JPanel WMS_AddWorker;
    private JLabel testLbl;

    public WMS_AddWorker(){
        setContentPane(WMS_AddWorker);
        setTitle("WMS Add Worker");
        setSize(640, 480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame WMSAddWorker = new WMS_AddWorker();
        WMSAddWorker.pack();
    }
}