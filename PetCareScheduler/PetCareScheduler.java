import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PetCareScheduler {
    private static final String DATA_FILE = "pets.dat";
    private static Map<String, Pet> pets = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadData();
        boolean running = true;

        while (running) {
            System.out.println("\n Paws & Whiskers - Pet Care Scheduler");
            System.out.println("1. Register a Pet");
            System.out.println("2. Schedule an Appointment");
            System.out.println("3. Display Records");
            System.out.println("4. Generate Reports");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    registerPet();
                    break;
                case "2":
                    scheduleAppointment();
                    break;
                case "3":
                    displayRecords();
                    break;
                case "4":
                    generateReports();
                    break;
                case "5":
                    saveData();
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }

        }
    }

    private static void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            pets = (HashMap<String, Pet>) ois.readObject();
        } catch (Exception e) {
            pets = new HashMap<>();
        }
    }

    private static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(pets);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private static void registerPet() {
        System.out.print("Enter Pet ID: ");
        String petId = scanner.nextLine();
        if (pets.containsKey(petId)) {
            System.out.println("Pet ID already exists.");
            return;
        }

        System.out.print("Enter Pet Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Species/Breed: ");
        String species = scanner.nextLine();

        int age;
        try {
            System.out.print("Enter Age: ");
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid age.");
            return;
        }

        System.out.print("Enter Owner Name: ");
        String ownerName = scanner.nextLine();

        System.out.print("Enter Contact Info: ");
        String contactInfo = scanner.nextLine();

        Pet newPet = new Pet(petId, name, species, age, ownerName, contactInfo);
        pets.put(petId, newPet);

        System.out.println("Pet registered: " + newPet);
    }

    private static void scheduleAppointment() {
        System.out.print("Enter Pet ID: ");
        String petId = scanner.nextLine();

        Pet pet = pets.get(petId);
        if (pet == null) {
            System.out.println("Pet not found!, Please register first.");
            return;
        }

        System.out.print("Enter Appointment Type (Vet, Vaccination, Grooming): ");
        String type = scanner.nextLine();

        LocalDateTime dateTime;
        try {
            System.out.print("Enter Date & Time (yyyy-MM-dd HH:mm): ");
            String input = scanner.nextLine();
            dateTime = LocalDateTime.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        } catch (Exception e) {
            System.out.println("Invalid date/time format.");
            return;
        }

        System.out.print("Enter Notes (optional): ");
        String notes = scanner.nextLine();

        Appointment appointment = new Appointment(type, dateTime, notes);
        pet.addAppointment(appointment);

        System.out.println("Appointment scheduled: " + appointment);

    }

    private static void displayRecords() {
        System.out.println("1. All Pets");
        System.out.println("2. Appointments for a Pet");
        System.out.println("3. Upcoming Appointments (all pets)");
        System.out.println("4. Past Appointment History (all pets)");
        System.out.print("Choose an option: ");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                pets.values().forEach(System.out::println);
                break;
            case "2":
                System.out.print("Enter Pet ID: ");
                String petId = scanner.nextLine();
                Pet pet = pets.get(petId);
                if (pet != null) {
                    pet.getAppointments().forEach(System.out::println);
                } else {
                    System.out.println("Pet not found.");
                }
                break;
            case "3":
                LocalDateTime now = LocalDateTime.now();
                pets.values().forEach(p -> p.getAppointments().stream()
                        .filter(a -> a.getDateTime().isAfter(now))
                        .forEach(a -> System.out.println(p.getName() + ": " + a)));
                break;
            case "4":
                LocalDateTime today = LocalDateTime.now();
                pets.values().forEach(p -> p.getAppointments().stream()
                        .filter(a -> a.getDateTime().isBefore(today))
                        .forEach(a -> System.out.println(p.getName() + ": " + a)));
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void generateReports() {
        System.out.println("1. Pets with appointments in the next week");
        System.out.println("2. Pets overdue for a vet visit (>6 months)");
        System.out.print("Choose an option: ");

        String choice = scanner.nextLine();
        LocalDateTime now = LocalDateTime.now();

        switch (choice) {
            case "1":
                LocalDateTime weekAhead = now.plusWeeks(1);
                pets.values().forEach(p -> p.getAppointments().stream()
                        .filter(a -> a.getDateTime().isAfter(now) && a.getDateTime().isBefore(weekAhead))
                        .forEach(a -> System.out.println(p.getName() + ": " + a)));
                break;
            case "2":
                pets.values().forEach(p -> {
                    Optional<Appointment> lastVetVisit = p.getAppointments().stream()
                            .filter(a -> a.getType().equalsIgnoreCase("Vet"))
                            .max(Comparator.comparing(Appointment::getDateTime));

                    if (lastVetVisit.isEmpty() ||
                            lastVetVisit.get().getDateTime().isBefore(now.minusMonths(6))) {
                        System.out.println(p.getName() + " is overdue for a vet visit.");
                    }
                });
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}
