import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashboardFrame extends JFrame {
    public DashboardFrame() {
        setTitle("Dashboard - HMS");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));

        JButton managePatientsButton = new JButton("Manage Patients");
        JButton manageDoctorsButton = new JButton("Manage Doctors");
        JButton bookAppointmentButton = new JButton("Book Appointment");
        JButton generateBillButton = new JButton("Generate Bill");
        JButton logoutButton = new JButton("Logout");

        add(managePatientsButton);
        add(manageDoctorsButton);
        add(bookAppointmentButton);
        add(generateBillButton);
        add(logoutButton);

        managePatientsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PatientForm();
            }
        });

        manageDoctorsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DoctorForm();
            }
        });

        bookAppointmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AppointmentForm();
            }
        });

        generateBillButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BillingForm();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginFrame();
                dispose();
            }
        });

        setVisible(true);
    }
}
