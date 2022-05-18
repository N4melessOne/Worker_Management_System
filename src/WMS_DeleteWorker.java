import javax.swing.*;

public class WMS_DeleteWorker extends JFrame{
    private JPanel WMS_DeleteWorker;
    private JTextField idTb;
    private JButton deleteWorkerBtn;
    private JLabel idLbl;

    public WMS_DeleteWorker(){
        setContentPane(WMS_DeleteWorker);
        setTitle("WMS Delete Worker");
        setLocationRelativeTo(null);
        setSize(320,200);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame WMSDeleteWorker = new WMS_DeleteWorker();
        WMSDeleteWorker.pack();
    }
}