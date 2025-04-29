import java.io.*;
import java.util.*;

public class Patient {
    private String id;
    private String name;
    private int age;
    private String contact;
    private String disease;

    public Patient(String id, String name, int age, String contact, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.disease = disease;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getContact() { return contact; }
    public String getDisease() { return disease; }

    public String toFileString() {
        return id + "," + name + "," + age + "," + contact + "," + disease;
    }

    public static void savePatient(Patient p) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("patients.txt", true));
            writer.write(p.toFileString());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving patient.");
        }
    }

    public static List<Patient> loadPatients() {
        List<Patient> patients = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("patients.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Patient p = new Patient(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4]);
                patients.add(p);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading patients.");
        }
        return patients;
    }
}
