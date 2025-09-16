import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment implements Serializable{
    private static final long serialVersionUID = 1L;
    private String type;
    private LocalDateTime dateTime;
    private String notes;

    public Appointment(String type, LocalDateTime dateTime, String notes) {
        this.type = type;
        this.dateTime = dateTime;
        this.notes = notes;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Type: " + type + ", Date: " + dateTime.format(formatter) + 
               (notes != null && !notes.isEmpty() ? ", Notes: " + notes : "");
    }

}
