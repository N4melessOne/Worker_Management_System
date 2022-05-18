import javax.swing.*;

public class WMS_DeletePlant extends JFrame{
    private JPanel WMS_DeletePlant;
    private JTextField idTb;
    private JButton deleteBtn;
    private JLabel idLbl;

    public WMS_DeletePlant(){
        setContentPane(WMS_DeletePlant);
        setTitle("WMS Delete Plant");
        setLocationRelativeTo(null);
        setSize(320,200);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame WMSDeletePlant = new WMS_DeletePlant();
        WMSDeletePlant.pack();
    }
}