import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WMS_LoginForm extends JFrame{
    private JPanel WMS_LoginForm;
    private JTextField idTb;
    private JLabel idLbl;
    private JButton idOkBtn;


    public WMS_LoginForm(){
        setContentPane(WMS_LoginForm);
        setTitle("WMS Login As Leader");
        setLocationRelativeTo(null);
        setSize(320,200);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        idOkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    int temp;
                    if (Helper.tryParse(idTb.getText()) == true) {
                        temp = Integer.parseInt(idTb.getText());
                        ResultSet result = SQLHandler.executeSelect(String.format("SELECT leader, workerName FROM workers WHERE workerId=%d", temp));
                        ArrayList<String> resultList = new ArrayList<String>();
                        while (result.next()){
                            resultList.add(result.getString("leader"));
                            resultList.add(result.getString("workerName"));
                        }

                        if(!resultList.isEmpty() && resultList.get(0).equals("1")){
                            JOptionPane.showMessageDialog(WMS_LoginForm, "You are successfully logged in as a leader!");
                            WMS_Main.setLeaderSignedIn(true);
                            try{
                                Log mainLog = new Log("log.txt");
                                mainLog.logger.info(String.format("%s has logged in.", resultList.get(1)));
                            } catch(Exception exception){}

                            dispose();
                        }
                        else {
                            try {
                                Log mainLog = new Log("log.txt");
                                mainLog.logger.info(String.format("%s has tried to log in.", resultList.get(1)));
                            } catch (Exception exception) {
                            }
                        }
                    }
                }catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame WMSLoginForm = new WMS_LoginForm();
        WMSLoginForm.pack();
    }
}
