import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WMS_DeleteWorker extends JFrame{
    private JPanel WMS_DeleteWorker;
    private JTextField idTb;
    private JButton deleteBtn;
    private JLabel idLbl;

    public WMS_DeleteWorker(){
        setContentPane(WMS_DeleteWorker);
        setTitle("WMS Delete Worker");
        setLocationRelativeTo(null);
        setSize(320,200);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int temp;
                if (Helper.tryParse(idTb.getText()) == true) {
                    temp = Integer.parseInt(idTb.getText());
                    Boolean deleted = SQLHandler.executeDelete(String.format("DELETE FROM workers WHERE workerId=%d", temp));

                    if(deleted){
                        JOptionPane.showMessageDialog(WMS_DeleteWorker, String.format("You have successfully deleted the %d. worker.", temp));
                        dispose();
                    }
                    else
                        JOptionPane.showMessageDialog(WMS_DeleteWorker, String.format("There is no worker, with the id of %d.", temp));
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame WMSDeleteWorker = new WMS_DeleteWorker();
        WMSDeleteWorker.pack();
    }
}