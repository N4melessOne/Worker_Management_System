import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private JButton loginBtn;
    private WMS_AddPlant addPlant;
    private WMS_AddDepartment addDepartment;
    private WMS_AddWorker addWorker;
    private WMS_DeletePlant deletePlant;
    private WMS_DeleteDepartment deleteDepartment;
    private WMS_DeleteWorker deleteWorker;
    private WMS_LoginForm loginForm;
    public static Logger logger;

    public static Boolean getLeaderSignedIn() {
        return isLeaderSignedIn;
    }
    public static void setLeaderSignedIn(Boolean leaderSignedIn) {
        isLeaderSignedIn = leaderSignedIn;
    }
    private static Boolean isLeaderSignedIn = false;

    public void modifyFunctions(){
        addPlantBtn.setEnabled(isLeaderSignedIn);
        addDepartmentBtn.setEnabled(isLeaderSignedIn);
        addWorkerBtn.setEnabled(isLeaderSignedIn);
        deletePlantBtn.setEnabled(isLeaderSignedIn);
        deleteDepartmentBtn.setEnabled(isLeaderSignedIn);
        deleteWorkerBtn.setEnabled(isLeaderSignedIn);
        loginBtn.setEnabled(!isLeaderSignedIn);
    }

    public WMS_Main(){
        setContentPane(WMS_MainWindow);
        setTitle("WMS Main Window");
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            createUIComponents();
        } catch (SQLException e) {
            //TODO:log if there are any problems!
        }
        setVisible(true);
        setLocationRelativeTo(null);
        modifyFunctions();


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
        addWorkerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addWorker == null){
                    addWorker = new WMS_AddWorker();
                    addWorker.toFront();
                }
                else {
                    addWorker.dispose();
                    addWorker = null;
                }
            }
        });
        deletePlantBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (deletePlant == null){
                    deletePlant = new WMS_DeletePlant();
                    deletePlant.toFront();
                }
                else {
                    deletePlant.dispose();
                    deletePlant = null;
                }
            }
        });
        deleteDepartmentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (deleteDepartment == null){
                    deleteDepartment = new WMS_DeleteDepartment();
                    deleteDepartment.toFront();
                }
                else {
                    deleteDepartment.dispose();
                    deleteDepartment = null;
                }
            }
        });
        deleteWorkerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (deleteWorker == null){
                    deleteWorker = new WMS_DeleteWorker();
                    deleteWorker.toFront();
                }
                else {
                    deleteWorker.dispose();
                    deleteWorker = null;
                }
            }
        });
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loginForm == null){
                    loginForm = new WMS_LoginForm();
                    loginForm.toFront();
                }
                else {
                    loginForm.dispose();
                    loginForm = null;
                    modifyFunctions();
                }
            }
        });

        plantsTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {

            }
        });
    }

    public static DefaultMutableTreeNode getPlantsTree() throws SQLException {
        DefaultMutableTreeNode plantsNode = new DefaultMutableTreeNode("Plants");
        ResultSet plantResult = SQLHandler.executeSelect("SELECT plantId,plantName FROM plants");
        while(plantResult.next()){
            DefaultMutableTreeNode plantNode = new DefaultMutableTreeNode(plantResult.getString(2));
            ResultSet departmentResult = SQLHandler.executeSelect(String.format("SELECT departmentName FROM department INNER JOIN departmentInPlant " +
                    "ON (department.departmentId=departmentInPlant.departmentId) INNER JOIN plants ON (plants.plantId=departmentInPlant.plantId) WHERE plants.plantId=%d",plantResult.getInt(1)));
            while(departmentResult.next()){
                DefaultMutableTreeNode departmentNode = new DefaultMutableTreeNode(departmentResult.getString(1));
                plantNode.add(departmentNode);
            }
            plantsNode.add(plantNode);
        }
        return plantsNode;
    }

    public static JTable getWorkers(){
        String[][] data = {{"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"},
                {"0", "0", "0", "0", "0", "0", "0", "0"}};
        String[] columns = {"Name", "Address", "Date of Birth", "Post", "Mobile", "Email", "Salary"};
        JTable tempTable = new JTable(data, columns);

        return  tempTable;
    }

    public static void main(String[] args) throws SQLException {
        //WMS_Main.logger = Logger.getLogger("log");
        //logger.setLevel(Level.INFO);
        //logger.info(String.format("The application has been started \t %s", Timestamp.valueOf(LocalDateTime.now()).toString()));


        SQLHandler.connect("jdbc:mariadb://localhost:3306/worker_management_system");
        JFrame WMSMainWindow = new WMS_Main();
        WMSMainWindow.pack();
    }

    private void createUIComponents() throws SQLException {
        plantsTree = new JTree(WMS_Main.getPlantsTree());
        plantsTree.setScrollsOnExpand(true);
        workersTable = WMS_Main.getWorkers();
    }
}
