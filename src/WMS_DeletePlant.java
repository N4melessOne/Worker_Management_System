import javax.swing.*;

public class WMS_DeletePlant extends JFrame{
    private JPanel WMS_DeletePlant;
    private JLabel testLbl;

    public WMS_DeletePlant(){
        setContentPane(WMS_DeletePlant);
        setTitle("WMS Add Plant");
        setSize(640, 480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame WMSDeletePlant = new WMS_DeletePlant();
        WMSDeletePlant.pack();
    }
}