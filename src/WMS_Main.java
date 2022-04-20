import javax.swing.*;

public class WMS_Main extends JFrame{
    private JPanel WMS_MainWindow;
    private JLabel PlantsLbl;
    private JList PlantsList;
    private JLabel EnterpriseNameLbl;

    public static void main(String[] args) {
        JFrame WMSMainWindow = new JFrame("WMS_Main");
        WMSMainWindow.setContentPane(new WMS_Main().WMS_MainWindow);
        WMSMainWindow.pack();
        WMSMainWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        WMSMainWindow.setVisible(true);
        System.out.println("ÜDV");
    }
}
