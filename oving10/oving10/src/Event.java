import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {
    private static int counter = 0;
    private int id;
    private String name;
    private String location;
    private long date;
    private String category;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HHmmssddMMyyyy");

    public Event(String name, String location, String dateString, String category) {
        this.id = ++counter;
        this.name = name;
        this.location = location;
        this.date = parseDate(dateString);
        this.category = category;
    }

    private long parseDate(String dateString) {
        try {
            Date date = DATE_FORMAT.parse(dateString);
            return date.getTime();
        } catch (ParseException e) {
            System.out.println("Invalid date format. Expected format is HHmmssddMMyyyy.");
            return 0;
        }
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public long getDate() {
        return date;
    }

    

    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", date=" + DATE_FORMAT.format(new Date(date)) + 
                ", category='" + category + '\'' +
                '}';
    }
}
