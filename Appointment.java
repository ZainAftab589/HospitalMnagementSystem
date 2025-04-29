import java.io.*;
import java.util.*;

public class Appointment {
    private String patientId;
    private String doctorId;
    private String date;
    private String status;

    public Appointment(String patientId, String doctorId, String date, String status) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.status = status;
    }

    public String toFileString() {
        return patientId + "," + doctorId + "," + date + "," + status;
    }

    public static void saveAppointment(Appointment a) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("appointments.txt", true));
            writer.write(a.toFileString());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving appointment.");
        }
    }

    public static List<Appointment> loadAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("appointments.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Appointment a = new Appointment(data[0], data[1], data[2], data[3]);
                appointments.add(a);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading appointments.");
        }
        return appointments;
    }
}
