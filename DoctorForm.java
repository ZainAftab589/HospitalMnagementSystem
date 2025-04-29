import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DoctorForm extends JFrame {
    private JTextField idField, nameField, specializationField, availabilityField;
    private JButton saveButton;

    public DoctorForm() {
        setTitle("Add Doctor");
        setSize(400, 250);
        setLayout(new GridLayout(5, 2, 5, 5));
        setLocationRelativeTo(null);

        add(new JLabel("Doctor ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Specialization:"));
        specializationField = new JTextField();
        add(specializationField);

        add(new JLabel("Availability:"));
        availabilityField = new JTextField();
        add(availabilityField);

        saveButton = new JButton("Save Doctor");
        add(new JLabel(""));
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Doctor d = new Doctor(idField.getText(), nameField.getText(),
                        specializationField.getText(), availabilityField.getText());
                Doctor.saveDoctor(d);
                JOptionPane.showMessageDialog(null, "Doctor saved!");
                dispose();
            }
        });

        setVisible(true);
    }
}
