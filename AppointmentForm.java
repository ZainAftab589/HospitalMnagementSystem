import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppointmentForm extends JFrame {
    private JTextField patientIdField, doctorIdField, dateField, statusField;
    private JButton saveButton;

    public AppointmentForm() {
        setTitle("Book Appointment");
        setSize(400, 250);
        setLayout(new GridLayout(5, 2, 5, 5));
        setLocationRelativeTo(null);

        add(new JLabel("Patient ID:"));
        patientIdField = new JTextField();
        add(patientIdField);

        add(new JLabel("Doctor ID:"));
        doctorIdField = new JTextField();
        add(doctorIdField);

        add(new JLabel("Date (DD-MM-YYYY):"));
        dateField = new JTextField();
        add(dateField);

        add(new JLabel("Status:"));
        statusField = new JTextField();
        add(statusField);

        saveButton = new JButton("Save Appointment");
        add(new JLabel(""));
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Appointment a = new Appointment(patientIdField.getText(), doctorIdField.getText(),
                        dateField.getText(), statusField.getText());
                Appointment.saveAppointment(a);
                JOptionPane.showMessageDialog(null, "Appointment booked!");
                dispose();
            }
        });

        setVisible(true);
    }
}
