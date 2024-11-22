package oving10;

public class Event {
    private int id;
    private String name;
    private String location;
    private String organizer;
    private String category;
    private String date;

    public Event(int id, String name, String location, String organizer, String category, String date) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.organizer = organizer;
        this.category = category;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getOrganizer() {
        return organizer;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }
}
