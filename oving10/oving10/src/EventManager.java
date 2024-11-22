import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventManager {
    private ArrayList<Event> eventList;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HHmmssddMMyyyy");

    public EventManager() {
        this.eventList = new ArrayList<>();
    }

    public void registerEvent(String name, String location, String date, String category) {
        Event newEvent = new Event(name, location, date, category);
        eventList.add(newEvent);
    }

    public void eventByLocation(String location) {
        eventList.stream().filter(event -> event.getLocation().equals(location)).forEach(System.out::println);
    }

    public void eventByDate(long date) {
        eventList.stream().filter(event -> event.getDate() == (date)).forEach(System.out::println);
    }

    public void eventByTimeFrame(long date1, long date2) {
        eventList.stream().filter(event -> event.getDate() < date2 && event.getDate() > date1).sorted().forEach(System.out::println);
    }

    public long convertDateStringToLong(String dateString) {
        try {
            Date date = DATE_FORMAT.parse(dateString);
            return date.getTime();
        } catch (ParseException e) {
            System.out.println("Invalid date format: " + dateString);
            return 0;
        }
    }

    public ArrayList<Event> eventSorter(int choice) {
        switch(choice) {
            case 1 -> {
                eventList.sort(Comparator.comparing(Event::getDate));
            }
            case 2 -> {
                eventList.sort(Comparator.comparing(Event::getCategory));
            }
            case 3 -> {
                eventList.sort(Comparator.comparing(Event::getDate));
            }
            case 4 -> {
                eventList.sort(Comparator.comparing(Event::getLocation));
            }
        }
        return eventList;
    }

    public void displayEvents() {
        eventList.forEach(System.out::println);
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder("EventManager:\n");
        for (Event event : eventList) {
            sb.append(event).append("\n");
        }
        return sb.toString();
    }
}


