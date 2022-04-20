import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WMS_Main extends JFrame{
    private JPanel WMS_MainWindow;
    private JTree plantsTree;
    private JLabel enterpriseNameLbl;
    private JLabel plantsLbl;
    private JButton addPlantBtn;


    public WMS_Main(){
        setContentPane(WMS_MainWindow);
        setTitle("WMS Main Window");
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createUIComponents();
        setVisible(true);

        addPlantBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WMS_Add_Plant add_plant = new WMS_Add_Plant();
                add_plant.setVisible(true);
            }
        });
    }

    public static DefaultMutableTreeNode getPlantsTree(){
        DefaultMutableTreeNode plant0 = new DefaultMutableTreeNode("Plant0");
        DefaultMutableTreeNode div0 = new DefaultMutableTreeNode("division0");
        DefaultMutableTreeNode div1 = new DefaultMutableTreeNode("division1");
        DefaultMutableTreeNode div2 = new DefaultMutableTreeNode("division2");
        plant0.add(div0);
        plant0.add(div1);
        plant0.add(div2);

        DefaultMutableTreeNode plant1= new DefaultMutableTreeNode("Plant1");
        DefaultMutableTreeNode div3 = new DefaultMutableTreeNode("division3");
        DefaultMutableTreeNode div4 = new DefaultMutableTreeNode("division4");
        DefaultMutableTreeNode div5 = new DefaultMutableTreeNode("division5");
        plant1.add(div3);
        plant1.add(div4);
        plant1.add(div5);

        DefaultMutableTreeNode plant2 = new DefaultMutableTreeNode("Plant2");
        DefaultMutableTreeNode div6 = new DefaultMutableTreeNode("division6");
        DefaultMutableTreeNode div7 = new DefaultMutableTreeNode("division7");
        DefaultMutableTreeNode div8 = new DefaultMutableTreeNode("division8");
        plant2.add(div6);
        plant2.add(div7);
        plant2.add(div8);

        DefaultMutableTreeNode plants = new DefaultMutableTreeNode("Plants");
        plants.add(plant0);
        plants.add(plant1);
        plants.add(plant2);

        return plants;
    }

    public static void main(String[] args) {
        JFrame WMSMainWindow = new WMS_Main();
        WMSMainWindow.pack();
    }

    private void createUIComponents() {
        plantsTree = new JTree(WMS_Main.getPlantsTree());
        plantsTree.setScrollsOnExpand(true);
    }
}
