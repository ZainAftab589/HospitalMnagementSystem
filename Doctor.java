public class Doctor extends Person {
    private String specialization;
    private boolean available;

    public Doctor(String name, int age, String contact, String specialization, boolean available) {
        super(name, age, contact);
        this.specialization = specialization;
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailability(boolean status) {
        this.available = status;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Specialization: " + specialization);
        System.out.println("Available: " + (available ? "Yes" : "No"));
    }
}
