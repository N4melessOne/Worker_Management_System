import BaseClasses.Enterprise;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private Enterprise enterprise;

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
        try {
            enterprise = initializeEnterprise();
        } catch (SQLException e) {
            //TODO:Log if there are any problems!
        }
        enterpriseNameLbl.setText(enterprise.getEnterpriseName());
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

    public static JTable getWorkers() throws SQLException {
        JTable workerTable;
        String[] columns = {"Name", "Address", "Date of Birth", "ID of Department", "ID of Plant",
                            "Is leader", "Mobile", "Email", "Salary"};
        ResultSet workerResult = SQLHandler.executeSelect("SELECT * FROM workers");
        int numberOfRows = SQLHandler.countResult(workerResult);
        String[][] workerData = new String[numberOfRows][9];
        workerResult = SQLHandler.executeSelect("SELECT * FROM workers");
        int i = 0;
        while(workerResult.next()){
            workerData[i][0] = workerResult.getString("workerName");
            workerData[i][1] = workerResult.getString("workerAddress");
            workerData[i][2] = workerResult.getString("birthDate");
            workerData[i][3] = workerResult.getString("departmentId");
            workerData[i][4] = workerResult.getString("plantId");
            workerData[i][5] = workerResult.getString("leader");
            workerData[i][6] = workerResult.getString("mobile");
            workerData[i][7] = workerResult.getString("email");
            workerData[i][8] = workerResult.getString("salary");
            i++;
        }
        DefaultTableModel workerTableModel = new DefaultTableModel(workerData, columns);
        workerTable = new JTable(workerTableModel);
        return workerTable;
    }

    public static Enterprise initializeEnterprise() throws SQLException {
        ResultSet resultEnterprise = SQLHandler.executeSelect("SELECT * FROM enterprise");
        String enterpriseName = null;
        int id = 0, sumRevenue = 0, sumCost = 0, profit = 0;
        while (resultEnterprise.next()){
            id = resultEnterprise.getInt("enterpriseId");
            enterpriseName = resultEnterprise.getString("enterpriseName");
            sumRevenue = resultEnterprise.getInt("sumRevenue");
            sumCost = resultEnterprise.getInt("sumCost");
            profit = resultEnterprise.getInt("profit");
        }

        Enterprise enterprise = Enterprise.GetInstance(id, enterpriseName, sumRevenue, sumCost, profit);
        return enterprise;
    }

    public static void main(String[] args) throws SQLException {
        try{
         Log.Logg("log.txt", "The application has been started.");
        } catch(Exception e){

        }
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
