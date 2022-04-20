import javax.swing.*;

public class WMS_Main extends JFrame{
    private JPanel WMS_MainWindow;
    private JLabel PlantsLbl;
    private JList list1;

    public static void main(String[] args) {
        JFrame WMSMainWindow = new JFrame("WMS_Main");
        WMSMainWindow.setVisible(true);
        WMSMainWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        WMSMainWindow.pack();
    }
}
