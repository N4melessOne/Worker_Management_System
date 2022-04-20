import javax.swing.*;

public class WMS_Add_Plant extends JFrame{
    private JPanel WMS_AddPlant;
    private JLabel testLbl;

    public WMS_Add_Plant(){
        setContentPane(WMS_AddPlant);
        setTitle("WMS Add Plant");
        setSize(640, 480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame WMSAddPlant = new WMS_Add_Plant();
        WMSAddPlant.pack();
    }
}
