public class Patient extends Person {
    private String disease;

    public Patient(String name, int age, String contact, String disease) {
        super(name, age, contact);
        this.disease = disease;
    }

    public String getDisease() {
        return disease;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Disease: " + disease);
    }
}
