import javax.swing.*;

public class WMS_DeleteWorker extends JFrame{
    private JPanel WMS_DeleteWorker;
    private JLabel testLbl;

    public WMS_DeleteWorker(){
        setContentPane(WMS_DeleteWorker);
        setTitle("WMS Add Plant");
        setSize(640, 480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame WMSDeleteWorker = new WMS_DeleteWorker();
        WMSDeleteWorker.pack();
    }
}