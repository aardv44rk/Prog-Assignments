package oving10;

public class EventManager {
    public ArrayList<Event> eventList;

    public void registerEvent() {

    }

    public void eventByLocation(String location) {
        eventList.stream().filter(event -> event.getLocation().equals(location)).forEach(System.out::println);
    }

    public void eventByDate() {

    }

    public void eventByTimeFrame() {

    }

    public void eventSorter() {

    }
    
}

