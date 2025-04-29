import java.io.*;
import java.util.*;

public class Billing {
    private String patientId;
    private double totalAmount;
    private String paymentStatus;

    public Billing(String patientId, double totalAmount, String paymentStatus) {
        this.patientId = patientId;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
    }

    public String toFileString() {
        return patientId + "," + totalAmount + "," + paymentStatus;
    }

    public static void saveBilling(Billing b) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("billing.txt", true));
            writer.write(b.toFileString());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving billing.");
        }
    }

    public static List<Billing> loadBilling() {
        List<Billing> billings = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("billing.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Billing b = new Billing(data[0], Double.parseDouble(data[1]), data[2]);
                billings.add(b);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading billing.");
        }
        return billings;
    }
}
