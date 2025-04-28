public class Billing {
    private Patient patient;
    private double amount;

    public Billing(Patient patient, double amount) {
        this.patient = patient;
        this.amount = amount;
    }

    public void generateBill() {
        System.out.println("Bill for Patient:");
        patient.displayInfo();
        System.out.println("Total Amount: $" + amount);
    }
}
