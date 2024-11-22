import java.util.Scanner;

public class App {
    private EventManager manager;
    private Scanner scanner;

    public App() {
        this.manager = new EventManager();
        this.scanner = new Scanner(System.in);
        initDummyEvents();
    }

    public void displayMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Event Manager Menu ---");
            System.out.println("1. Register a new event");
            System.out.println("2. Display all events");
            System.out.println("3. Filter events by location");
            System.out.println("4. Filter events by date");
            System.out.println("5. Filter events by timeframe");
            System.out.println("6. Sort events");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> registerNewEvent();
                case 2 -> manager.displayEvents();
                case 3 -> filterByLocation();
                case 4 -> filterByDate();
                case 5 -> filterByTimeFrame();
                case 6 -> sortEvents();
                case 0 -> running = false;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
        System.out.println("Exiting Event Manager. Goodbye!");
    }

    private void initDummyEvents() {
        manager.registerEvent("Nordic Music Festival", "Oslo", "12000001012023", "Music");
        manager.registerEvent("Tech Innovation Summit", "Trondheim", "09000002012023", "Tech");
        manager.registerEvent("Art Exhibition", "Bergen", "15000003012023", "Art");
        manager.registerEvent("Winter Sports Gala", "Lillehammer", "18000004012023", "Sports");
        manager.registerEvent("Cultural Heritage Conference", "Stavanger", "10000005012023", "Conference");
        manager.registerEvent("Science Fair", "Tromsø", "14000006012023", "Education");
        manager.registerEvent("Film Festival", "Oslo", "20000007012023", "Film");
    }

    private void registerNewEvent() {
        System.out.print("Enter event name: ");
        String name = scanner.nextLine();
        System.out.print("Enter location: ");
        String location = scanner.nextLine();
        System.out.print("Enter date (HHmmssddMMyyyy): ");
        String date = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        manager.registerEvent(name, location, date, category);
        System.out.println("Event registered successfully.");
    }

    private void filterByLocation() {
        System.out.print("Enter location to filter by: ");
        String location = scanner.nextLine();
        System.out.println("Events at location '" + location + "':");
        manager.eventByLocation(location);
    }

    private void filterByDate() {
        System.out.print("Enter date to filter by (HHmmssddMMyyyy): ");
        String dateString = scanner.nextLine();
        long dateInMilliseconds = manager.convertDateStringToLong(dateString);
        System.out.println("Events on date '" + dateString + "':");
        manager.eventByDate(dateInMilliseconds);
    }

    private void filterByTimeFrame() {
        System.out.print("Enter start date (HHmmssddMMyyyy): ");
        String startDateString = scanner.nextLine();
        long startDate = manager.convertDateStringToLong(startDateString);

        System.out.print("Enter end date (HHmmssddMMyyyy): ");
        String endDateString = scanner.nextLine();
        long endDate = manager.convertDateStringToLong(endDateString);

        System.out.println("Events between '" + startDateString + "' and '" + endDateString + "':");
        manager.eventByTimeFrame(startDate, endDate);
    }

    private void sortEvents() {
        System.out.println("Sort events by:");
        System.out.println("1. Date");
        System.out.println("2. Category");
        System.out.println("3. Date (again)");
        System.out.println("4. Location");
        int sortChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        manager.eventSorter(sortChoice);
        System.out.println("Events sorted successfully.");
        manager.displayEvents();
    }

    public static void main(String[] args) {
        App menu = new App();
        menu.displayMenu();
    }
}
