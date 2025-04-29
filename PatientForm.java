import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PatientForm extends JFrame {
    private JTextField idField, nameField, ageField, contactField, diseaseField;
    private JButton saveButton;

    public PatientForm() {
        setTitle("Add Patient");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2, 5, 5));
        setLocationRelativeTo(null);

        add(new JLabel("Patient ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);

        add(new JLabel("Contact:"));
        contactField = new JTextField();
        add(contactField);

        add(new JLabel("Disease:"));
        diseaseField = new JTextField();
        add(diseaseField);

        saveButton = new JButton("Save Patient");
        add(new JLabel(""));
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Patient p = new Patient(idField.getText(), nameField.getText(),
                        Integer.parseInt(ageField.getText()), contactField.getText(), diseaseField.getText());
                Patient.savePatient(p);
                JOptionPane.showMessageDialog(null, "Patient saved!");
                dispose();
            }
        });

        setVisible(true);
    }
}
