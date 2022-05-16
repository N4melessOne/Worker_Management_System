import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WMS_Main extends JFrame{
    private JPanel WMS_MainWindow;
    private JTree plantsTree;
    private JLabel enterpriseNameLbl;
    private JLabel plantsLbl;
    private JButton addPlantBtn;
    private JTable workersTable;
    private JButton addDepartmentBtn;
    private JButton deletePlantBtn;
    private JButton deleteDepartmentBtn;
    private JButton addWorkerBtn;
    private JButton deleteWorkerBtn;
    private WMS_AddPlant addPlant;
    private WMS_AddDepartment addDepartment;
    private WMS_DeletePlant deletePlant;
    private WMS_DeleteDepartment deleteDepartment;
    private WMS_AddWorker addWorker;
    private WMS_DeleteWorker deleteWorker;


    public WMS_Main(){
        setContentPane(WMS_MainWindow);
        setTitle("WMS Main Window");
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createUIComponents();
        addPlant = null;
        addDepartment = null;
        setVisible(true);

        addPlantBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addPlant == null){
                    addPlant = new WMS_AddPlant();
                    addPlant.toFront();
                }
                else {
                    addPlant.dispose();
                    addPlant = null;
                }
            }
        });
        addDepartmentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addDepartment == null){
                    addDepartment = new WMS_AddDepartment();
                    addDepartment.toFront();
                }
                else {
                    addDepartment.dispose();
                    addDepartment = null;
                }
            }
        });
        plantsTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //Validálni, hogy mi a neve az adott node-nak
                //Ha plant van a nevében, akkor ModifyPlant, ha division, akkor DDivModify!
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

    public static JTable getWorkers(){
        String[][] data = {{"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"}};
        String[] columns = {"Name", "Address", "Date of Birth", "Post", "Mobile", "Email", "Salary", "Sex"};
        JTable tempTable = new JTable(data, columns);

        return  tempTable;
    }

    public static void main(String[] args) {
        JFrame WMSMainWindow = new WMS_Main();
        WMSMainWindow.pack();
    }

    private void createUIComponents() {
        plantsTree = new JTree(WMS_Main.getPlantsTree());
        plantsTree.setScrollsOnExpand(true);
        workersTable = WMS_Main.getWorkers();
    }
}
