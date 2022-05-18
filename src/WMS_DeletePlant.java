import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WMS_DeletePlant extends JFrame{
    private JPanel WMS_DeletePlant;
    private JTextField idTb;
    private JButton deleteBtn;
    private JLabel idLbl;

    public WMS_DeletePlant(){
        setContentPane(WMS_DeletePlant);
        setTitle("WMS Delete Plant");
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
                    Boolean deleted = SQLHandler.executeDelete(String.format("DELETE FROM plant WHERE plantId=%d", temp));

                    if(deleted){
                        JOptionPane.showMessageDialog(WMS_DeletePlant, String.format("You have successfully deleted the %d. plant.", temp));
                        dispose();
                    }
                    else
                        JOptionPane.showMessageDialog(WMS_DeletePlant, String.format("There is no plant, with the id of %d.", temp));
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame WMSDeletePlant = new WMS_DeletePlant();
        WMSDeletePlant.pack();
    }
}