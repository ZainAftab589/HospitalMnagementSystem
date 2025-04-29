import java.io.*;
import java.util.*;

public class Doctor {
    private String id;
    private String name;
    private String specialization;
    private String availability;

    public Doctor(String id, String name, String specialization, String availability) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public String getAvailability() { return availability; }

    public String toFileString() {
        return id + "," + name + "," + specialization + "," + availability;
    }

    public static void saveDoctor(Doctor d) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("doctors.txt", true));
            writer.write(d.toFileString());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving doctor.");
        }
    }

    public static List<Doctor> loadDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("doctors.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Doctor d = new Doctor(data[0], data[1], data[2], data[3]);
                doctors.add(d);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading doctors.");
        }
        return doctors;
    }
}
