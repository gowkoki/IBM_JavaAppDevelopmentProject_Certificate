import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Pet implements Serializable {
    private static final long serialVersionUID = 1L;
    private String petId;
    private String name;
    private String species;
    private int age;
    private String ownerName;
    private String contactInfo;
    private LocalDate registrationDate;
    private List<Appointment> appointments;

    public Pet(String petId, String name, String species, int age, String ownerName, String contactInfo) {
        this.petId = petId;
        this.name = name;
        this.species = species;
        this.age = age;
        this.ownerName = ownerName;
        this.contactInfo = contactInfo;
        this.registrationDate = LocalDate.now();
        this.appointments = new ArrayList<>();
    }

    public String getPetId() {
        return petId;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    @Override
    public String toString() {
        return "Pet ID: " + petId + ", Name: " + name + ", Species: " + species + 
               ", Age: " + age + ", Owner: " + ownerName + ", Contact: " + contactInfo + 
               ", Registered: " + registrationDate;
    }
}
