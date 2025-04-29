import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BillingForm extends JFrame {
    private JTextField patientIdField, amountField, paymentStatusField;
    private JButton saveButton;

    public BillingForm() {
        setTitle("Generate Bill");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2, 5, 5));
        setLocationRelativeTo(null);

        add(new JLabel("Patient ID:"));
        patientIdField = new JTextField();
        add(patientIdField);

        add(new JLabel("Total Amount:"));
        amountField = new JTextField();
        add(amountField);

        add(new JLabel("Payment Status (Paid/Unpaid):"));
        paymentStatusField = new JTextField();
        add(paymentStatusField);

        saveButton = new JButton("Save Bill");
        add(new JLabel(""));
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Billing b = new Billing(patientIdField.getText(),
                        Double.parseDouble(amountField.getText()), paymentStatusField.getText());
                Billing.saveBilling(b);
                JOptionPane.showMessageDialog(null, "Bill generated!");
                dispose();
            }
        });

        setVisible(true);
    }
}
