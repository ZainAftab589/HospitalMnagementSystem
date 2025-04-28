import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Dummy doctors
        doctors.add(new Doctor("Dr. Smith", 45, "1234567890", "Cardiologist", true));
        doctors.add(new Doctor("Dr. Johnson", 38, "0987654321", "Dermatologist", true));

        while (true) {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. View Doctors");
            System.out.println("4. Book Appointment");
            System.out.println("5. Generate Bill");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addPatient(input);
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    viewDoctors();
                    break;
                case 4:
                    bookAppointment(input);
                    break;
                case 5:
                    generateBill(input);
                    break;
                case 6:
                    System.out.println("Exiting System. Thank you!");
                    input.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice. Try Again.");
            }
        }
    }

    private static void addPatient(Scanner input) {
        System.out.print("Enter Patient Name: ");
        String name = input.nextLine();
        System.out.print("Enter Age: ");
        int age = input.nextInt();
        input.nextLine();
        System.out.print("Enter Contact: ");
        String contact = input.nextLine();
        System.out.print("Enter Disease: ");
        String disease = input.nextLine();

        Patient p = new Patient(name, age, contact, disease);
        patients.add(p);
        System.out.println("Patient added successfully!");

        // Save to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("patients.txt", true))) {
            writer.write(name + "," + age + "," + contact + "," + disease);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving patient to file.");
        }
    }

    private static void viewPatients() {
        System.out.println("\n--- Patient List ---");
        for (Patient p : patients) {
            p.displayInfo();
            System.out.println("---------------------");
        }
    }

    private static void viewDoctors() {
        System.out.println("\n--- Doctor List ---");
        for (Doctor d : doctors) {
            d.displayInfo();
            System.out.println("---------------------");
        }
    }

    private static void bookAppointment(Scanner input) {
        if (patients.isEmpty() || doctors.isEmpty()) {
            System.out.println("Patients or Doctors are missing!");
            return;
        }

        System.out.println("Select Patient:");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i).name);
        }
        int patientChoice = input.nextInt() - 1;

        System.out.println("Select Doctor:");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i).name + (doctors.get(i).isAvailable() ? " (Available)" : " (Unavailable)"));
        }
        int doctorChoice = input.nextInt() - 1;
        input.nextLine(); // consume newline

        if (!doctors.get(doctorChoice).isAvailable()) {
            System.out.println("Selected doctor is not available!");
            return;
        }

        System.out.print("Enter Appointment Date (dd/mm/yyyy): ");
        String date = input.nextLine();

        Appointment app = new Appointment(patients.get(patientChoice), doctors.get(doctorChoice), date);
        appointments.add(app);
        doctors.get(doctorChoice).setAvailability(false); // Mark doctor unavailable

        System.out.println("Appointment Booked Successfully!");

        // Save appointment to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("appointments.txt", true))) {
            writer.write(patients.get(patientChoice).name + "," + doctors.get(doctorChoice).name + "," + date);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving appointment to file.");
        }
    }

    private static void generateBill(Scanner input) {
        if (patients.isEmpty()) {
            System.out.println("No patients available!");
            return;
        }

        System.out.println("Select Patient for Billing:");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i).name);
        }
        int patientChoice = input.nextInt() - 1;

        System.out.print("Enter Amount: ");
        double amount = input.nextDouble();

        Billing bill = new Billing(patients.get(patientChoice), amount);
        bill.generateBill();

        // Save bill to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("bills.txt", true))) {
            writer.write(patients.get(patientChoice).name + "," + amount);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving bill to file.");
        }
    }
}
