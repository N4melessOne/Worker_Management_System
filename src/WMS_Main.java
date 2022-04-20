import javax.swing.*;

public class WMS_Main extends JFrame{
    private JPanel WMS_MainWindow;

    public WMS_Main(){
        setContentPane(WMS_MainWindow);
        setTitle("WMS Main Window");
        setSize(1920, 1080);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame WMSMainWindow = new JFrame("WMS_Main");
        WMSMainWindow.pack();
    }
}
